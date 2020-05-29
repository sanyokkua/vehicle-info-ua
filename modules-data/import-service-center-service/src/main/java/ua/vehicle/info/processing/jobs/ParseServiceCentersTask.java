package ua.vehicle.info.processing.jobs;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.aspects.annotations.LogInputOutput;
import ua.vehicle.info.aspects.annotations.LogTimeMeasures;
import ua.vehicle.info.dto.ServiceCenterRecord;
import ua.vehicle.info.processing.processor.Task;

/**
 * The type Parse service centers task.
 */
public class ParseServiceCentersTask implements Task<Elements, Iterator<ServiceCenterRecord>> {

    private static final Pattern DIGITS_ONLY = Pattern.compile("\\d+");

    @LogTimeMeasures
    @LogInputOutput
    @LogExceptions
    @Override
    public Iterator<ServiceCenterRecord> process(Elements input) {
        return input.stream()
                .map(this::mapToProperElements)
                .filter(this::filterBySize)
                .map(this::mapToServiceCenter)
                .collect(Collectors.toList())
                .iterator();
    }

    private List<Element> mapToProperElements(Element tr) {
        return tr.childNodes()
                .stream()
                .filter(node -> node instanceof Element)
                .map(node -> ((Element) node))
                .filter(element -> StringUtils.isNotBlank(element.text()))
                .collect(Collectors.toList());
    }

    private boolean filterBySize(List<Element> list) {
        return list.size() > 4;
    }

    private ServiceCenterRecord mapToServiceCenter(List<Element> list) {
        var departmentId = list.get(0).text().trim();
        var matcher = DIGITS_ONLY.matcher(departmentId);
        long depId = 0;
        if (matcher.find()) {
            depId = Long.parseLong(matcher.group());
        }
        var address = list.get(1).text().trim();
        var email = list.get(4).text().trim();
        return new ServiceCenterRecord(depId, address, email);
    }
}
