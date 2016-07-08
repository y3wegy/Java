/**
 * Created by a549238 on 5/6/2015.
 */

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 */
public class TestOracle {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@hzpdl3209.it.statestr.com:1522:O09ISZ0";
            conn = DriverManager.getConnection(url, "INFRA", "INFRA");
            stmt = conn.createStatement();
            for (long i = 201504231000282611l; i < 201504231000282711l; i++) {
                String sql = "insert into reg_registration values ('9','" + i + "', 'REG','E801','F','E ASIA LEATHER CORPORATION HAMB105','C/O BILLS','E ASIA LEATHER CORPORATION HAMB105','600','GB0002405495','','11QSKG00003','001','','','PENDING','20150414232957869','A586747','20150423043436575','','E801','E801')";
                stmt.addBatch(sql);
            }
            stmt.executeBatch();
            conn.commit();
            System.out.println("Complete it!");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                // rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testDB() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@gdcx11-scan:1521:fdr.prod.adhoc";
            conn = DriverManager.getConnection(url, "e482589", "Gtsaus70");
            stmt = conn.prepareStatement("SELECT decode('D','D',NAV_DAY_DT,NAV_ME_DT),  'D' FREQUENCY_FLAG,\n" +
                    " A.FUND_ID Fund ,a.ASSET_ID,\n" +
                    "CASE  WHEN Event_Type_CD IN ('INCDIV') THEN 'Dividend Received'\n" +
                    "WHEN Event_Type_CD IN ('INCDIV C')  THEN 'Dividend Received Cancellation'\n" +
                    "WHEN EVENT_TYPE_CD IN ('INCINT')  THEN 'Interest Received'\n" +
                    "WHEN EVENT_TYPE_CD IN ('INCINT C')    THEN 'Interest Received Cancellation'\n" +
                    "WHEN EVENT_TYPE_CD IN ('SINCINT')    THEN 'Interest Paid'\n" +
                    "WHEN EVENT_TYPE_CD IN ('SINCINTC')    THEN 'Interest Paid Cancellation'\n" +
                    "WHEN EVENT_TYPE_CD IN ('SINCDIV')    THEN 'Dividend Paid '\n" +
                    "WHEN EVENT_TYPE_CD IN ('SINCDIVC')    THEN 'Dividend Paid Cancellation'\n" +
                    "WHEN EVENT_TYPE_CD IN ('INCINTN')    THEN 'MBS interest Received'\n" +
                    "WHEN EVENT_TYPE_CD IN ('INCINTNC')    THEN 'MBS interest Received Cancellation'\n" +
                    "WHEN EVENT_TYPE_CD IN ('INCRFDD')    THEN 'Dividend Tax Reclaim Received'\n" +
                    "WHEN EVENT_TYPE_CD IN ('INCRFDDC')    THEN 'Dividend Tax Reclaim Received Cancellation'\n" +
                    "WHEN EVENT_TYPE_CD IN ('INCRFDI')    THEN 'Interest Tax Reclaim Received'\n" +
                    "WHEN EVENT_TYPE_CD IN ('INCRFDIC')    THEN 'Interest Tax Reclaim Received Cancellation'\n" +
                    "END AS EVENT_TYPE_DESC, A.CRNT_DT, A.DATA_SRC_CD,A.ME_DT,A.PERIOD_IND_CD,A.PRIOR_DT,  A.PRIOR_ME_DT, A.PRIOR_PRIOR_DT,\n" +
                    "A.PRIOR_PRIOR_ME_DT,A.BASE_CNTRY_CD,A.CLIENT_ID,A.CRNCY_CD_BASE,A.CRNT_XCHRT,A.DATED_DT,\n" +
                    "A.DENOM_CRNCY_CD,A.END_OF_PERIOD_EFF_DT,A.END_OF_PERIOD_EVENT_TS,A.FIRST_INCM_DT,\n" +
                    "A.FISC_YE_DT,A.FUND_NM,A.INCM_CRNCY_CD,A.INCM_FREQ_CD,A.INCORP_CNTRY_CD,A.INVEST_TYPE_CD,\n" +
                    "A.ISSUE_CNTRY_CD,A.ISSUE_LONG_NM,A.ISSUE_SHORT_NM,A.LOAD_TIME_STAMP,A.MAT_DT,\n" +
                    "A.NRA_TAX_CNTRY_CD,A.PAR_CRNCY_CD,A.POS_MTRTY_DT,A.TICKER_SYMB,A.TRD_CNTRY_CD,\n" +
                    "A.TRD_CRNCY_CD, A.XCHRT_ME_SRC_CD,A.XCHRT_PRC_SRC_CD,A.XCHRT_SRC_CD,A.ADJST_POST_DT,A.ADJST_RPT_DT,\n" +
                    "A.ADJUST_NUM,A.ALT_ISIN_ID,A.ALT_SEDOL_ID,A.ALT_TKR_ID,A.ASSET_GRP_CD,\n" +
                    "A.ASSET_GRP_NM, A.DUE_DT,A.EVENT_TYPE_CD,A.EXDVND_DT,A.GRS_INCM_BAM,\n" +
                    "A.GRS_INCM_LAM, A.INCM_RT, A.INCM_TRD_ID_NUM,  A.LOT_ACCT_NUM,  A.NAV_DAY_DT,\n" +
                    "A.NAV_ME_DT,A.NAV_YE_DT,A.NETGL_RCVD_AMT,A.NETRCVB_ADJ_BAM,A.NETRCVB_ADJ_LAM,\n" +
                    "A.NETRCVB_BAM,A.NETRCVB_LAM,A.NETRCVD_BAM,A.NETRCVD_LAM,A.NETRCVD_QTY,A.NETRCVD_STATUS_CD,\n" +
                    "A.NET_ADJST_QTY, A.ORIG_NETRCVB_BAM, A.ORIG_NETRCVB_LAM,A.ORIG_SHRPAR_QTY,A.POST_DT,\n" +
                    "A.PRINCIPAL_BAM,A.PRINCIPAL_LAM,A.RCVD_DT,A.RCVD_RPT_DT,A.RECORD_DT,A.RPT_DT,A.SETUP_XCHRT,\n" +
                    "A.TAXEXP_BAM,A.TAXEXP_LAM,A.TAXRCL_ACCRD_BAM,A.TAXRCL_ACCRD_LAM,A.TAXRCL_RCVD_BAM,\n" +
                    "A.TAXRCL_RCVD_LAM,A.TAXWTH_ACCRD_BAM,A.TAXWTH_ACCRD_LAM,A.TAX_MARKER_CD,A.CNCL_IND,\n" +
                    "B.SUBJECT_AREA_CD,B.ANCR_PRIOR_PER_EFF_DT,B.LATEST_REFRESH_EFF_DT,\n" +
                    "A.load_time_stamp SRC_LAST_UPDATE_DT,NULL SRC_LAST_UPDATE_BY,'RTS' APP_CD,\n" +
                    "to_date(to_char(CURRENT_DATE,'yyyy-MM-dd HH24:mi:ss'),'yyyy-MM-dd HH24:mi:ss')  LAST_UPDATE_DATE,'a549238' LAST_UPDATE_BY\n" +
                    "FROM TABLE(FDR_DAL_ICM_RCVD.GET_ICM_RCVD_CONSOL(\n" +
                    "(SELECT CAST(COLLECT(FUND_ID) AS SHORT_STRING_COL) FROM V_REF_FUND_HEADER WHERE  client_id in ('SYR9')\n" +
                    " ), decode('D','D','NAV_DAY_DT','NAV_ME_DT'), SHORT_STRING_COL('MCH','OTC'), TO_DATE('2016-06-13','yyyy-MM-dd'), TO_DATE('2016-06-13','yyyy-MM-dd'), NULL )) A ,\n" +
                    " ( SELECT * FROM TABLE (fdr_dal_ref.get_ref_fund_status (\n" +
                    "(SELECT CAST(COLLECT(FUND_ID)\n" +
                    "AS LONG_STRING_COL) FROM V_REF_FUND_HEADER WHERE CLIENT_ID IN ('SYR9')),\n" +
                    "'D',short_string_col ('ANCHOR'))) WHERE subject_area_cd = 'PRDCLOSED' ) B\n" +
                    "WHERE A.fund_id=b.fund_id and NAV_DAY_DT between TO_DATE('2016-06-13','yyyy-MM-dd') and TO_DATE('2016-06-13','yyyy-MM-dd')\n" +
                    "AND  (b.ancr_prior_per_eff_dt>=TO_DATE('2016-06-13','yyyy-MM-dd')\n" +
                    "OR (b.ancr_prior_per_eff_dt>=TO_DATE('2016-06-13','yyyy-MM-dd') and b.ancr_prior_per_eff_dt<TO_DATE('2016-06-13','yyyy-MM-dd')\n" +
                    "AND NAV_DAY_DT between TO_DATE('2016-06-13','yyyy-MM-dd') and b.ancr_prior_per_eff_dt))");
            rs = stmt.executeQuery();
            List<Object[]> results = new ArrayList<Object[]>();
            Object[] result;
            int colCount = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                result = new Object[colCount];
                for (int i = 1; i <= colCount; i++) {
                    result[i - 1] = rs.getObject(i);

                }
                results.add(result);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Complete it!");
    }

}


