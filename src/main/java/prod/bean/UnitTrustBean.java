package prod.bean;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by a549238 on 4/5/2017.
 */
public class UnitTrustBean extends AbstractRecord {
    private static final Logger logger = Logger.getLogger(UnitTrustBean.class);

    public static final int SHEET_INDEX = 0;
    public static final int HEADER_INDEX = 0;

    protected static final Map<String, String> fieldNameMapping = new HashMap<>();
    protected final Map<String, Object> fieldValueMap = new LinkedHashMap<>();

    static {
        fieldNameMapping.put("AppCode", "APP_CD");
        fieldNameMapping.put("Status", "STATUS");
        fieldNameMapping.put("Action", "ACTION");
        fieldNameMapping.put("Client ID", "CLIENT_ID");
        fieldNameMapping.put("Fund ID", "APPLY_TO_FUND");
        fieldNameMapping.put("Asset ID", "ASSET_ID");
        fieldNameMapping.put("Security Long Name", "ISSUE_LONG_NM");
        fieldNameMapping.put("ASX/Internal Code", "ASX_INTL_CD");
        fieldNameMapping.put("Ex Date", "EXDVND_DT");
        fieldNameMapping.put("Pay Date", "DUE_DT");
        fieldNameMapping.put("Source", "SOURCE");
        fieldNameMapping.put("Source - Details", "SOURCE_SUB_TYPE");
        fieldNameMapping.put("Comment", "COMMENTS");
        fieldNameMapping.put("Shares", "SHARES");
        fieldNameMapping.put("Cents", "CPU_FLAG");
        fieldNameMapping.put("MCH Net Income Rate (DPU)", "MCH_NET_INCM_DPU_RT");
        fieldNameMapping.put("MCH Net Income Rate (CPU)", "MCH_NET_INCM_CPU_RT");
        fieldNameMapping.put("Net Income Amount", "NET_INCM_AMT");
        fieldNameMapping.put("Gross Income Amount", "GROSS_INCM_AMT");
        fieldNameMapping.put("Return of Capital - Cost Base Reclass", "RTN_OF_CAP_COST_BASE_RECLASS");
        fieldNameMapping.put("CFI Unfranked Dividends", "CFI_UNFRANKED_DVNDS");
        fieldNameMapping.put("Cost Base Uplift", "COST_BASE_UPLIFT");
        fieldNameMapping.put("Domestic Expenses", "DOMESTIC_EXPS");
        fieldNameMapping.put("Domestic Other Income", "DOMESTIC_OTHER_INCM");
        fieldNameMapping.put("FITO - NTAP Discounted Gains", "FITO_DISCOUNTED_GAINS");
        fieldNameMapping.put("FITO - Income", "FITO_INCM");
        fieldNameMapping.put("Foreign Expenses", "FOREIGN_EXPS");
        fieldNameMapping.put("Franking Credits", "FRANKING_CREDITS");
        fieldNameMapping.put("Domestic Interest", "INT_DOM");
        fieldNameMapping.put("Domestic Interest - not subject to WHT", "INT_NOT_SUB_WHT_DOM");
        fieldNameMapping.put("Net Foreign Income", "NET_FOREIGN_INCM");
        fieldNameMapping.put("Net Franked Dividends", "NET_FRANKED_DVNDS");
        fieldNameMapping.put("NTAP CGT Concession", "NTAP_CGT_CONC");
        fieldNameMapping.put("NTAP Discounted Gains", "NTAP_DISCOUNTED_GAINS");
        fieldNameMapping.put("NTAP Discounted Gains- Domestic", "NTAP_DISCOUNTED_GAINS_DOM");
        fieldNameMapping.put("NTAP Discounted Gains - Foreign", "NTAP_DISCOUNTED_GAINS_FRN");
        fieldNameMapping.put("NTAP Other Capital Gains", "NTAP_OTHER_CAP_GAINS");
        fieldNameMapping.put("NZ Franking Credits", "NZ_FRANKING_CREDITS");
        fieldNameMapping.put("Return of Capital - Income", "RTN_INCM");
        fieldNameMapping.put("TAP CGT Concession", "TAP_CGT_CONC");
        fieldNameMapping.put("TAP Discounted Gains", "TAP_DISCOUNTED_GAINS");
        fieldNameMapping.put("TAP Indexed Gains", "TAP_IDX_GAINS");
        fieldNameMapping.put("TAP Other Capital Gains", "TAP_OTHER_CAP_GAINS");
        fieldNameMapping.put("Tax Deferred Amount", "TAX_DEFERRED_AMT");
        fieldNameMapping.put("Tax Exempted Amount", "TAX_EXEMPTED_AMT");
        fieldNameMapping.put("Tax Free Amount", "TAX_FREE_AMT");
        fieldNameMapping.put("Unfranked Dividends", "UNFRANKED_DVNDS");
    }

    public static AbstractRecord newInstance() {
        return new UnitTrustBean();
    }

    public static int getSheetIndex() {
        return SHEET_INDEX;
    }

    public static int getHeaderRowIndex() {
        return HEADER_INDEX;
    }

    public void add(String fieldName, Object value) {
        if (fieldNameMapping.containsKey(fieldName)) {
            String actualName = fieldNameMapping.get(fieldName);
            if ("CPU_FLAG".equals(actualName)) {
                fieldValueMap.put(actualName, "No".equals(value) ? "N" : "Y");
            } else {
                fieldValueMap.put(actualName, value);
            }
        } else {
            logger.warn(fieldName + " not found");
        }
    }

    @Override
    public void afterAction() {
        add("AppCode", "RTS");
        add("Action", "Add");
        add("Status", "Approved");

    }

    public Map<String, String> getFiledNameMap() {
        return fieldNameMapping;
    }

    public Map<String, Object> getValueMap() {
        return fieldValueMap;
    }

}
