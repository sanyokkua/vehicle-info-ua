package ua.vehicle.info.dto;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminUnitRecord {

    @SerializedName(value = "firstLevel", alternate = {"Перший рівень"})
    private String firstLevel;
    @SerializedName(value = "secondLevel", alternate = {"Другий рівень"})
    private String secondLevel;
    @SerializedName(value = "thirdLevel", alternate = {"Третій рівень"})
    private String thirdLevel;
    @SerializedName(value = "fourthLevel", alternate = {"Четвертий рівень"})
    private String fourthLevel;
    @SerializedName(value = "category", alternate = {"Категорія"})
    private String category;
    @SerializedName(value = "name", alternate = {"Назва об'єкта українською мовою"})
    private String name;
}

