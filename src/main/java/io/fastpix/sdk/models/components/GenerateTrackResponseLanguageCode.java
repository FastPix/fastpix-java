package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * GenerateTrackResponseLanguageCode
 *
 * <p>The BCP 47 language code representing the language of the generated track.
 *
 * <p>Wrapper for an "open" enum that can handle unknown values from API responses
 * without runtime errors. Instances are immutable singletons with reference equality.
 * Use {@code asEnum()} for switch expressions.
 */
public class GenerateTrackResponseLanguageCode {

    private static final String AR_SA_VALUE = "ar-SA";
    private static final String BN_BD_VALUE = "bn-BD";
    private static final String BN_IN_VALUE = "bn-IN";
    private static final String CA_ES_VALUE = "ca-ES";
    private static final String CS_CZ_VALUE = "cs-CZ";
    private static final String DA_DK_VALUE = "da-DK";
    private static final String DE_AT_VALUE = "de-AT";
    private static final String DE_CH_VALUE = "de-CH";
    private static final String DEDE_VALUE = "de-DE";
    private static final String EL_GR_VALUE = "el-GR";
    private static final String EN_AU_VALUE = "en-AU";
    private static final String EN_CA_VALUE = "en-CA";
    private static final String EN_GB_VALUE = "en-GB";
    private static final String EN_IE_VALUE = "en-IE";
    private static final String EN_IN_VALUE = "en-IN";
    private static final String EN_NZ_VALUE = "en-NZ";
    private static final String EN_US_VALUE = "en-US";
    private static final String EN_ZA_VALUE = "en-ZA";
    private static final String ES_AR_VALUE = "es-AR";
    private static final String ES_CL_VALUE = "es-CL";
    private static final String ES_CO_VALUE = "es-CO";
    private static final String ESES_VALUE = "es-ES";
    private static final String ES_MX_VALUE = "es-MX";
    private static final String ES_US_VALUE = "es-US";
    private static final String FIFI_VALUE = "fi-FI";
    private static final String FR_BE_VALUE = "fr-BE";
    private static final String FR_CA_VALUE = "fr-CA";
    private static final String FR_CH_VALUE = "fr-CH";
    private static final String FRFR_VALUE = "fr-FR";
    private static final String HE_IL_VALUE = "he-IL";
    private static final String HI_IN_VALUE = "hi-IN";
    private static final String HRHR_VALUE = "hr-HR";
    private static final String HUHU_VALUE = "hu-HU";
    private static final String IDID_VALUE = "id-ID";
    private static final String IT_CH_VALUE = "it-CH";
    private static final String ITIT_VALUE = "it-IT";
    private static final String JA_JP_VALUE = "ja-JP";
    private static final String KO_KR_VALUE = "ko-KR";
    private static final String NL_BE_VALUE = "nl-BE";
    private static final String NLNL_VALUE = "nl-NL";
    private static final String NONO_VALUE = "no-NO";
    private static final String PLPL_VALUE = "pl-PL";
    private static final String PT_BR_VALUE = "pt-BR";
    private static final String PTPT_VALUE = "pt-PT";
    private static final String RORO_VALUE = "ro-RO";
    private static final String RURU_VALUE = "ru-RU";
    private static final String SKSK_VALUE = "sk-SK";
    private static final String SV_SE_VALUE = "sv-SE";
    private static final String TA_IN_VALUE = "ta-IN";
    private static final String TA_LK_VALUE = "ta-LK";
    private static final String THTH_VALUE = "th-TH";
    private static final String TRTR_VALUE = "tr-TR";
    private static final String UK_UA_VALUE = "uk-UA";
    private static final String BGBG_VALUE = "bg-BG";
    private static final String ZH_CN_VALUE = "zh-CN";
    private static final String ZH_HK_VALUE = "zh-HK";
    private static final String ZH_TW_VALUE = "zh-TW";

    public static final GenerateTrackResponseLanguageCode AR_SA = new GenerateTrackResponseLanguageCode(AR_SA_VALUE);
    public static final GenerateTrackResponseLanguageCode BN_BD = new GenerateTrackResponseLanguageCode(BN_BD_VALUE);
    public static final GenerateTrackResponseLanguageCode BN_IN = new GenerateTrackResponseLanguageCode(BN_IN_VALUE);
    public static final GenerateTrackResponseLanguageCode CA_ES = new GenerateTrackResponseLanguageCode(CA_ES_VALUE);
    public static final GenerateTrackResponseLanguageCode CS_CZ = new GenerateTrackResponseLanguageCode(CS_CZ_VALUE);
    public static final GenerateTrackResponseLanguageCode DA_DK = new GenerateTrackResponseLanguageCode(DA_DK_VALUE);
    public static final GenerateTrackResponseLanguageCode DE_AT = new GenerateTrackResponseLanguageCode(DE_AT_VALUE);
    public static final GenerateTrackResponseLanguageCode DE_CH = new GenerateTrackResponseLanguageCode(DE_CH_VALUE);
    public static final GenerateTrackResponseLanguageCode DEDE = new GenerateTrackResponseLanguageCode(DEDE_VALUE);
    public static final GenerateTrackResponseLanguageCode EL_GR = new GenerateTrackResponseLanguageCode(EL_GR_VALUE);
    public static final GenerateTrackResponseLanguageCode EN_AU = new GenerateTrackResponseLanguageCode(EN_AU_VALUE);
    public static final GenerateTrackResponseLanguageCode EN_CA = new GenerateTrackResponseLanguageCode(EN_CA_VALUE);
    public static final GenerateTrackResponseLanguageCode EN_GB = new GenerateTrackResponseLanguageCode(EN_GB_VALUE);
    public static final GenerateTrackResponseLanguageCode EN_IE = new GenerateTrackResponseLanguageCode(EN_IE_VALUE);
    public static final GenerateTrackResponseLanguageCode EN_IN = new GenerateTrackResponseLanguageCode(EN_IN_VALUE);
    public static final GenerateTrackResponseLanguageCode EN_NZ = new GenerateTrackResponseLanguageCode(EN_NZ_VALUE);
    public static final GenerateTrackResponseLanguageCode EN_US = new GenerateTrackResponseLanguageCode(EN_US_VALUE);
    public static final GenerateTrackResponseLanguageCode EN_ZA = new GenerateTrackResponseLanguageCode(EN_ZA_VALUE);
    public static final GenerateTrackResponseLanguageCode ES_AR = new GenerateTrackResponseLanguageCode(ES_AR_VALUE);
    public static final GenerateTrackResponseLanguageCode ES_CL = new GenerateTrackResponseLanguageCode(ES_CL_VALUE);
    public static final GenerateTrackResponseLanguageCode ES_CO = new GenerateTrackResponseLanguageCode(ES_CO_VALUE);
    public static final GenerateTrackResponseLanguageCode ESES = new GenerateTrackResponseLanguageCode(ESES_VALUE);
    public static final GenerateTrackResponseLanguageCode ES_MX = new GenerateTrackResponseLanguageCode(ES_MX_VALUE);
    public static final GenerateTrackResponseLanguageCode ES_US = new GenerateTrackResponseLanguageCode(ES_US_VALUE);
    public static final GenerateTrackResponseLanguageCode FIFI = new GenerateTrackResponseLanguageCode(FIFI_VALUE);
    public static final GenerateTrackResponseLanguageCode FR_BE = new GenerateTrackResponseLanguageCode(FR_BE_VALUE);
    public static final GenerateTrackResponseLanguageCode FR_CA = new GenerateTrackResponseLanguageCode(FR_CA_VALUE);
    public static final GenerateTrackResponseLanguageCode FR_CH = new GenerateTrackResponseLanguageCode(FR_CH_VALUE);
    public static final GenerateTrackResponseLanguageCode FRFR = new GenerateTrackResponseLanguageCode(FRFR_VALUE);
    public static final GenerateTrackResponseLanguageCode HE_IL = new GenerateTrackResponseLanguageCode(HE_IL_VALUE);
    public static final GenerateTrackResponseLanguageCode HI_IN = new GenerateTrackResponseLanguageCode(HI_IN_VALUE);
    public static final GenerateTrackResponseLanguageCode HRHR = new GenerateTrackResponseLanguageCode(HRHR_VALUE);
    public static final GenerateTrackResponseLanguageCode HUHU = new GenerateTrackResponseLanguageCode(HUHU_VALUE);
    public static final GenerateTrackResponseLanguageCode IDID = new GenerateTrackResponseLanguageCode(IDID_VALUE);
    public static final GenerateTrackResponseLanguageCode IT_CH = new GenerateTrackResponseLanguageCode(IT_CH_VALUE);
    public static final GenerateTrackResponseLanguageCode ITIT = new GenerateTrackResponseLanguageCode(ITIT_VALUE);
    public static final GenerateTrackResponseLanguageCode JA_JP = new GenerateTrackResponseLanguageCode(JA_JP_VALUE);
    public static final GenerateTrackResponseLanguageCode KO_KR = new GenerateTrackResponseLanguageCode(KO_KR_VALUE);
    public static final GenerateTrackResponseLanguageCode NL_BE = new GenerateTrackResponseLanguageCode(NL_BE_VALUE);
    public static final GenerateTrackResponseLanguageCode NLNL = new GenerateTrackResponseLanguageCode(NLNL_VALUE);
    public static final GenerateTrackResponseLanguageCode NONO = new GenerateTrackResponseLanguageCode(NONO_VALUE);
    public static final GenerateTrackResponseLanguageCode PLPL = new GenerateTrackResponseLanguageCode(PLPL_VALUE);
    public static final GenerateTrackResponseLanguageCode PT_BR = new GenerateTrackResponseLanguageCode(PT_BR_VALUE);
    public static final GenerateTrackResponseLanguageCode PTPT = new GenerateTrackResponseLanguageCode(PTPT_VALUE);
    public static final GenerateTrackResponseLanguageCode RORO = new GenerateTrackResponseLanguageCode(RORO_VALUE);
    public static final GenerateTrackResponseLanguageCode RURU = new GenerateTrackResponseLanguageCode(RURU_VALUE);
    public static final GenerateTrackResponseLanguageCode SKSK = new GenerateTrackResponseLanguageCode(SKSK_VALUE);
    public static final GenerateTrackResponseLanguageCode SV_SE = new GenerateTrackResponseLanguageCode(SV_SE_VALUE);
    public static final GenerateTrackResponseLanguageCode TA_IN = new GenerateTrackResponseLanguageCode(TA_IN_VALUE);
    public static final GenerateTrackResponseLanguageCode TA_LK = new GenerateTrackResponseLanguageCode(TA_LK_VALUE);
    public static final GenerateTrackResponseLanguageCode THTH = new GenerateTrackResponseLanguageCode(THTH_VALUE);
    public static final GenerateTrackResponseLanguageCode TRTR = new GenerateTrackResponseLanguageCode(TRTR_VALUE);
    public static final GenerateTrackResponseLanguageCode UK_UA = new GenerateTrackResponseLanguageCode(UK_UA_VALUE);
    public static final GenerateTrackResponseLanguageCode BGBG = new GenerateTrackResponseLanguageCode(BGBG_VALUE);
    public static final GenerateTrackResponseLanguageCode ZH_CN = new GenerateTrackResponseLanguageCode(ZH_CN_VALUE);
    public static final GenerateTrackResponseLanguageCode ZH_HK = new GenerateTrackResponseLanguageCode(ZH_HK_VALUE);
    public static final GenerateTrackResponseLanguageCode ZH_TW = new GenerateTrackResponseLanguageCode(ZH_TW_VALUE);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, GenerateTrackResponseLanguageCode> values = createValuesMap();
    private static final Map<String, GenerateTrackResponseLanguageCodeEnum> enums = createEnumsMap();

    private final String value;

    private GenerateTrackResponseLanguageCode(String value) {
        this.value = value;
    }

    /**
     * Returns a GenerateTrackResponseLanguageCode with the given value. For a specific value the 
     * returned object will always be a singleton so reference equality 
     * is satisfied when the values are the same.
     * 
     * @param value value to be wrapped as GenerateTrackResponseLanguageCode
     */ 
    @JsonCreator
    public static GenerateTrackResponseLanguageCode of(String value) {
        synchronized (GenerateTrackResponseLanguageCode.class) {
            return values.computeIfAbsent(value, GenerateTrackResponseLanguageCode::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<GenerateTrackResponseLanguageCodeEnum> asEnum() {
        return Optional.ofNullable(enums.getOrDefault(value, null));
    }

    public boolean isKnown() {
        return asEnum().isPresent();
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(java.lang.Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GenerateTrackResponseLanguageCode other = (GenerateTrackResponseLanguageCode) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "GenerateTrackResponseLanguageCode [value=" + value + "]";
    }

    // return an array just like an enum
    public static GenerateTrackResponseLanguageCode[] values() {
        synchronized (GenerateTrackResponseLanguageCode.class) {
            return values.values().toArray(new GenerateTrackResponseLanguageCode[] {});
        }
    }

    private static final Map<String, GenerateTrackResponseLanguageCode> createValuesMap() {
        Map<String, GenerateTrackResponseLanguageCode> map = new LinkedHashMap<>();
        map.put(AR_SA_VALUE, AR_SA);
        map.put(BN_BD_VALUE, BN_BD);
        map.put(BN_IN_VALUE, BN_IN);
        map.put(CA_ES_VALUE, CA_ES);
        map.put(CS_CZ_VALUE, CS_CZ);
        map.put(DA_DK_VALUE, DA_DK);
        map.put(DE_AT_VALUE, DE_AT);
        map.put(DE_CH_VALUE, DE_CH);
        map.put(DEDE_VALUE, DEDE);
        map.put(EL_GR_VALUE, EL_GR);
        map.put(EN_AU_VALUE, EN_AU);
        map.put(EN_CA_VALUE, EN_CA);
        map.put(EN_GB_VALUE, EN_GB);
        map.put(EN_IE_VALUE, EN_IE);
        map.put(EN_IN_VALUE, EN_IN);
        map.put(EN_NZ_VALUE, EN_NZ);
        map.put(EN_US_VALUE, EN_US);
        map.put(EN_ZA_VALUE, EN_ZA);
        map.put(ES_AR_VALUE, ES_AR);
        map.put(ES_CL_VALUE, ES_CL);
        map.put(ES_CO_VALUE, ES_CO);
        map.put(ESES_VALUE, ESES);
        map.put(ES_MX_VALUE, ES_MX);
        map.put(ES_US_VALUE, ES_US);
        map.put(FIFI_VALUE, FIFI);
        map.put(FR_BE_VALUE, FR_BE);
        map.put(FR_CA_VALUE, FR_CA);
        map.put(FR_CH_VALUE, FR_CH);
        map.put(FRFR_VALUE, FRFR);
        map.put(HE_IL_VALUE, HE_IL);
        map.put(HI_IN_VALUE, HI_IN);
        map.put(HRHR_VALUE, HRHR);
        map.put(HUHU_VALUE, HUHU);
        map.put(IDID_VALUE, IDID);
        map.put(IT_CH_VALUE, IT_CH);
        map.put(ITIT_VALUE, ITIT);
        map.put(JA_JP_VALUE, JA_JP);
        map.put(KO_KR_VALUE, KO_KR);
        map.put(NL_BE_VALUE, NL_BE);
        map.put(NLNL_VALUE, NLNL);
        map.put(NONO_VALUE, NONO);
        map.put(PLPL_VALUE, PLPL);
        map.put(PT_BR_VALUE, PT_BR);
        map.put(PTPT_VALUE, PTPT);
        map.put(RORO_VALUE, RORO);
        map.put(RURU_VALUE, RURU);
        map.put(SKSK_VALUE, SKSK);
        map.put(SV_SE_VALUE, SV_SE);
        map.put(TA_IN_VALUE, TA_IN);
        map.put(TA_LK_VALUE, TA_LK);
        map.put(THTH_VALUE, THTH);
        map.put(TRTR_VALUE, TRTR);
        map.put(UK_UA_VALUE, UK_UA);
        map.put(BGBG_VALUE, BGBG);
        map.put(ZH_CN_VALUE, ZH_CN);
        map.put(ZH_HK_VALUE, ZH_HK);
        map.put(ZH_TW_VALUE, ZH_TW);
        return map;
    }

    private static final Map<String, GenerateTrackResponseLanguageCodeEnum> createEnumsMap() {
        Map<String, GenerateTrackResponseLanguageCodeEnum> map = new HashMap<>();
        map.put(AR_SA_VALUE, GenerateTrackResponseLanguageCodeEnum.AR_SA);
        map.put(BN_BD_VALUE, GenerateTrackResponseLanguageCodeEnum.BN_BD);
        map.put(BN_IN_VALUE, GenerateTrackResponseLanguageCodeEnum.BN_IN);
        map.put(CA_ES_VALUE, GenerateTrackResponseLanguageCodeEnum.CA_ES);
        map.put(CS_CZ_VALUE, GenerateTrackResponseLanguageCodeEnum.CS_CZ);
        map.put(DA_DK_VALUE, GenerateTrackResponseLanguageCodeEnum.DA_DK);
        map.put(DE_AT_VALUE, GenerateTrackResponseLanguageCodeEnum.DE_AT);
        map.put(DE_CH_VALUE, GenerateTrackResponseLanguageCodeEnum.DE_CH);
        map.put(DEDE_VALUE, GenerateTrackResponseLanguageCodeEnum.DEDE);
        map.put(EL_GR_VALUE, GenerateTrackResponseLanguageCodeEnum.EL_GR);
        map.put(EN_AU_VALUE, GenerateTrackResponseLanguageCodeEnum.EN_AU);
        map.put(EN_CA_VALUE, GenerateTrackResponseLanguageCodeEnum.EN_CA);
        map.put(EN_GB_VALUE, GenerateTrackResponseLanguageCodeEnum.EN_GB);
        map.put(EN_IE_VALUE, GenerateTrackResponseLanguageCodeEnum.EN_IE);
        map.put(EN_IN_VALUE, GenerateTrackResponseLanguageCodeEnum.EN_IN);
        map.put(EN_NZ_VALUE, GenerateTrackResponseLanguageCodeEnum.EN_NZ);
        map.put(EN_US_VALUE, GenerateTrackResponseLanguageCodeEnum.EN_US);
        map.put(EN_ZA_VALUE, GenerateTrackResponseLanguageCodeEnum.EN_ZA);
        map.put(ES_AR_VALUE, GenerateTrackResponseLanguageCodeEnum.ES_AR);
        map.put(ES_CL_VALUE, GenerateTrackResponseLanguageCodeEnum.ES_CL);
        map.put(ES_CO_VALUE, GenerateTrackResponseLanguageCodeEnum.ES_CO);
        map.put(ESES_VALUE, GenerateTrackResponseLanguageCodeEnum.ESES);
        map.put(ES_MX_VALUE, GenerateTrackResponseLanguageCodeEnum.ES_MX);
        map.put(ES_US_VALUE, GenerateTrackResponseLanguageCodeEnum.ES_US);
        map.put(FIFI_VALUE, GenerateTrackResponseLanguageCodeEnum.FIFI);
        map.put(FR_BE_VALUE, GenerateTrackResponseLanguageCodeEnum.FR_BE);
        map.put(FR_CA_VALUE, GenerateTrackResponseLanguageCodeEnum.FR_CA);
        map.put(FR_CH_VALUE, GenerateTrackResponseLanguageCodeEnum.FR_CH);
        map.put(FRFR_VALUE, GenerateTrackResponseLanguageCodeEnum.FRFR);
        map.put(HE_IL_VALUE, GenerateTrackResponseLanguageCodeEnum.HE_IL);
        map.put(HI_IN_VALUE, GenerateTrackResponseLanguageCodeEnum.HI_IN);
        map.put(HRHR_VALUE, GenerateTrackResponseLanguageCodeEnum.HRHR);
        map.put(HUHU_VALUE, GenerateTrackResponseLanguageCodeEnum.HUHU);
        map.put(IDID_VALUE, GenerateTrackResponseLanguageCodeEnum.IDID);
        map.put(IT_CH_VALUE, GenerateTrackResponseLanguageCodeEnum.IT_CH);
        map.put(ITIT_VALUE, GenerateTrackResponseLanguageCodeEnum.ITIT);
        map.put(JA_JP_VALUE, GenerateTrackResponseLanguageCodeEnum.JA_JP);
        map.put(KO_KR_VALUE, GenerateTrackResponseLanguageCodeEnum.KO_KR);
        map.put(NL_BE_VALUE, GenerateTrackResponseLanguageCodeEnum.NL_BE);
        map.put(NLNL_VALUE, GenerateTrackResponseLanguageCodeEnum.NLNL);
        map.put(NONO_VALUE, GenerateTrackResponseLanguageCodeEnum.NONO);
        map.put(PLPL_VALUE, GenerateTrackResponseLanguageCodeEnum.PLPL);
        map.put(PT_BR_VALUE, GenerateTrackResponseLanguageCodeEnum.PT_BR);
        map.put(PTPT_VALUE, GenerateTrackResponseLanguageCodeEnum.PTPT);
        map.put(RORO_VALUE, GenerateTrackResponseLanguageCodeEnum.RORO);
        map.put(RURU_VALUE, GenerateTrackResponseLanguageCodeEnum.RURU);
        map.put(SKSK_VALUE, GenerateTrackResponseLanguageCodeEnum.SKSK);
        map.put(SV_SE_VALUE, GenerateTrackResponseLanguageCodeEnum.SV_SE);
        map.put(TA_IN_VALUE, GenerateTrackResponseLanguageCodeEnum.TA_IN);
        map.put(TA_LK_VALUE, GenerateTrackResponseLanguageCodeEnum.TA_LK);
        map.put(THTH_VALUE, GenerateTrackResponseLanguageCodeEnum.THTH);
        map.put(TRTR_VALUE, GenerateTrackResponseLanguageCodeEnum.TRTR);
        map.put(UK_UA_VALUE, GenerateTrackResponseLanguageCodeEnum.UK_UA);
        map.put(BGBG_VALUE, GenerateTrackResponseLanguageCodeEnum.BGBG);
        map.put(ZH_CN_VALUE, GenerateTrackResponseLanguageCodeEnum.ZH_CN);
        map.put(ZH_HK_VALUE, GenerateTrackResponseLanguageCodeEnum.ZH_HK);
        map.put(ZH_TW_VALUE, GenerateTrackResponseLanguageCodeEnum.ZH_TW);
        return map;
    }
    
    
    public enum GenerateTrackResponseLanguageCodeEnum {

        AR_SA(AR_SA_VALUE),
        BN_BD(BN_BD_VALUE),
        BN_IN(BN_IN_VALUE),
        CA_ES(CA_ES_VALUE),
        CS_CZ(CS_CZ_VALUE),
        DA_DK(DA_DK_VALUE),
        DE_AT(DE_AT_VALUE),
        DE_CH(DE_CH_VALUE),
        DEDE(DEDE_VALUE),
        EL_GR(EL_GR_VALUE),
        EN_AU(EN_AU_VALUE),
        EN_CA(EN_CA_VALUE),
        EN_GB(EN_GB_VALUE),
        EN_IE(EN_IE_VALUE),
        EN_IN(EN_IN_VALUE),
        EN_NZ(EN_NZ_VALUE),
        EN_US(EN_US_VALUE),
        EN_ZA(EN_ZA_VALUE),
        ES_AR(ES_AR_VALUE),
        ES_CL(ES_CL_VALUE),
        ES_CO(ES_CO_VALUE),
        ESES(ESES_VALUE),
        ES_MX(ES_MX_VALUE),
        ES_US(ES_US_VALUE),
        FIFI(FIFI_VALUE),
        FR_BE(FR_BE_VALUE),
        FR_CA(FR_CA_VALUE),
        FR_CH(FR_CH_VALUE),
        FRFR(FRFR_VALUE),
        HE_IL(HE_IL_VALUE),
        HI_IN(HI_IN_VALUE),
        HRHR(HRHR_VALUE),
        HUHU(HUHU_VALUE),
        IDID(IDID_VALUE),
        IT_CH(IT_CH_VALUE),
        ITIT(ITIT_VALUE),
        JA_JP(JA_JP_VALUE),
        KO_KR(KO_KR_VALUE),
        NL_BE(NL_BE_VALUE),
        NLNL(NLNL_VALUE),
        NONO(NONO_VALUE),
        PLPL(PLPL_VALUE),
        PT_BR(PT_BR_VALUE),
        PTPT(PTPT_VALUE),
        RORO(RORO_VALUE),
        RURU(RURU_VALUE),
        SKSK(SKSK_VALUE),
        SV_SE(SV_SE_VALUE),
        TA_IN(TA_IN_VALUE),
        TA_LK(TA_LK_VALUE),
        THTH(THTH_VALUE),
        TRTR(TRTR_VALUE),
        UK_UA(UK_UA_VALUE),
        BGBG(BGBG_VALUE),
        ZH_CN(ZH_CN_VALUE),
        ZH_HK(ZH_HK_VALUE),
        ZH_TW(ZH_TW_VALUE),;

        private final String value;

        private GenerateTrackResponseLanguageCodeEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}
