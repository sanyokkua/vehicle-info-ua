package ua.vehicle.info.dto.registration;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRecord {

    @SerializedName(value = "PERSON", alternate = {"person"})
    private String personType;
    @SerializedName(value = "REG_ADDR_KOATUU", alternate = {"reg_addr_koatuu"})
    private Long administrativeTerritorialUnitCode;
    @SerializedName(value = "OPER_CODE", alternate = {"oper_code"})
    private Long operationCode;
    @SerializedName(value = "OPER_NAME", alternate = {"oper_name"})
    private String operationName;
    @SerializedName(value = "D_REG", alternate = {"d_reg"})
    private String registrationDate;
    @SerializedName(value = "DEP_CODE", alternate = {"dep_code"})
    private Long departmentCode;
    @SerializedName(value = "DEP", alternate = {"dep"})
    private String departmentName;
    @SerializedName(value = "BRAND", alternate = {"brand"})
    private String vehicleBrand;
    @SerializedName(value = "MODEL", alternate = {"model"})
    private String vehicleModel;
    @SerializedName(value = "MAKE_YEAR", alternate = {"make_year"})
    private Integer vehicleMakeYear;
    @SerializedName(value = "COLOR", alternate = {"color"})
    private String vehicleColor;
    @SerializedName(value = "KIND", alternate = {"kind"})
    private String vehicleKind;
    @SerializedName(value = "BODY", alternate = {"body"})
    private String vehicleBody;
    @SerializedName(value = "PURPOSE", alternate = {"purpose"})
    private String vehiclePurpose;
    @SerializedName(value = "FUEL", alternate = {"fuel"})
    private String vehicleFuelType;
    @SerializedName(value = "CAPACITY", alternate = {"capacity"})
    private Integer capacity;
    @SerializedName(value = "OWN_WEIGHT", alternate = {"own_weight"})
    private Double vehicleOwnWeight;
    @SerializedName(value = "TOTAL_WEIGHT", alternate = {"total_weight"})
    private Double vehicleTotalWeight;
    @SerializedName(value = "N_REG_NEW", alternate = {"n_reg_new"})
    private String registrationNumber;
}
