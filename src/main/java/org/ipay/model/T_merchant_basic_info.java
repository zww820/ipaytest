package org.ipay.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class T_merchant_basic_info implements Serializable {
    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : ID
     */
    private Long ID;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : MERCHANT_ID
     */
    private BigDecimal MERCHANT_ID;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : MERCHANT_CODE
     */
    private String MERCHANT_CODE;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : THREE_IN_ONE_CERT
     */
    private String THREE_IN_ONE_CERT;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : MERCHANT_NAME
     */
    private String MERCHANT_NAME;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : MERCHANT_SHORT_NAME
     */
    private String MERCHANT_SHORT_NAME;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : BUSINESS_LICENSE_NO
     */
    private String BUSINESS_LICENSE_NO;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : OPERATOR_NAME
     */
    private String OPERATOR_NAME;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : CERT_TYPE
     */
    private String CERT_TYPE;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : CERT_CODE
     */
    private String CERT_CODE;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : INDUSTRY_ID_3
     */
    private BigDecimal INDUSTRY_ID_3;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : BUSINESS_DISTRICT_ID
     */
    private BigDecimal BUSINESS_DISTRICT_ID;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : PROVINCE_ID
     */
    private BigDecimal PROVINCE_ID;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : CITY_ID
     */
    private BigDecimal CITY_ID;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : DISTRICT_ID
     */
    private BigDecimal DISTRICT_ID;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : ADDRESS
     */
    private String ADDRESS;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : MOBILE_PHONE
     */
    private String MOBILE_PHONE;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : FIXED_PHONE
     */
    private String FIXED_PHONE;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : CONCERN_TYPE
     */
    private String CONCERN_TYPE;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : MERCHANT_TYPE
     */
    private String MERCHANT_TYPE;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : EMAIL
     */
    private String EMAIL;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : HOME_PAGE
     */
    private String HOME_PAGE;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : REMARK
     */
    private String REMARK;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : BANK_CODE
     */
    private String BANK_CODE;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : ACCT_NAME
     */
    private String ACCT_NAME;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : ACCT_NO
     */
    private BigDecimal ACCT_NO;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : ACCT_TYPE
     */
    private String ACCT_TYPE;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : NATIVE_FLAG
     */
    private String NATIVE_FLAG;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : RATE_ID
     */
    private BigDecimal RATE_ID;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : SETTL_CYCLE_CODE
     */
    private String SETTL_CYCLE_CODE;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : INDEPENDENT_ACCOUNTING
     */
    private String INDEPENDENT_ACCOUNTING;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : RESERVE_NO
     */
    private BigDecimal RESERVE_NO;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : RECOMMENDER
     */
    private BigDecimal RECOMMENDER;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : MCC_ID
     */
    private BigDecimal MCC_ID;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : URL_BUSINESS_LICENCE
     */
    private String URL_BUSINESS_LICENCE;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : URL_ORG_CODE_CERT
     */
    private String URL_ORG_CODE_CERT;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : URL_TAX_REG_CERT
     */
    private String URL_TAX_REG_CERT;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : URL_OPEN_ACCOUNT_CERT
     */
    private String URL_OPEN_ACCOUNT_CERT;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : URL_SETTL_ACCOUNT
     */
    private String URL_SETTL_ACCOUNT;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : URL_PERSON_PHOTO
     */
    private String URL_PERSON_PHOTO;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : URL_ID_CARD1
     */
    private String URL_ID_CARD1;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : URL_ID_CARD2
     */
    private String URL_ID_CARD2;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : URL_SHOP_PIC1
     */
    private String URL_SHOP_PIC1;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : URL_SHOP_PIC2
     */
    private String URL_SHOP_PIC2;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : URL_MERCHANT_AGREEMENT
     */
    private String URL_MERCHANT_AGREEMENT;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : URL_APPLICATION_FORM
     */
    private String URL_APPLICATION_FORM;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : URL_MERCHANT_COMM_LETTER
     */
    private String URL_MERCHANT_COMM_LETTER;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : URL_AUTH_BOOK
     */
    private String URL_AUTH_BOOK;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : URL_OTHER_AGREEMENT
     */
    private String URL_OTHER_AGREEMENT;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : MERCHANT_REMARK
     */
    private String MERCHANT_REMARK;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : MODIFY_ID
     */
    private BigDecimal MODIFY_ID;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : MODIFY_TIME
     */
    private Date MODIFY_TIME;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : CREATED_ID
     */
    private BigDecimal CREATED_ID;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : CREATED_TIME
     */
    private Date CREATED_TIME;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : UPDATED_ID
     */
    private BigDecimal UPDATED_ID;

    /**
     * 表 : T_MERCHANT_BASIC_INFO
     * 对应字段 : UPDATED_TIME
     */
    private Date UPDATED_TIME;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_MERCHANT_BASIC_INFO
     *
     * @MBG Generated Fri Sep 01 17:19:47 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.ID：null
     */
    public Long getID() {
        return ID;
    }

    /**
     * set method 
     *
     * @param ID  null
     */
    public void setID(Long ID) {
        this.ID = ID;
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.MERCHANT_ID：null
     */
    public BigDecimal getMERCHANT_ID() {
        return MERCHANT_ID;
    }

    /**
     * set method 
     *
     * @param MERCHANT_ID  null
     */
    public void setMERCHANT_ID(BigDecimal MERCHANT_ID) {
        this.MERCHANT_ID = MERCHANT_ID;
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.MERCHANT_CODE：null
     */
    public String getMERCHANT_CODE() {
        return MERCHANT_CODE;
    }

    /**
     * set method 
     *
     * @param MERCHANT_CODE  null
     */
    public void setMERCHANT_CODE(String MERCHANT_CODE) {
        this.MERCHANT_CODE = MERCHANT_CODE == null ? null : MERCHANT_CODE.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.THREE_IN_ONE_CERT：null
     */
    public String getTHREE_IN_ONE_CERT() {
        return THREE_IN_ONE_CERT;
    }

    /**
     * set method 
     *
     * @param THREE_IN_ONE_CERT  null
     */
    public void setTHREE_IN_ONE_CERT(String THREE_IN_ONE_CERT) {
        this.THREE_IN_ONE_CERT = THREE_IN_ONE_CERT == null ? null : THREE_IN_ONE_CERT.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.MERCHANT_NAME：null
     */
    public String getMERCHANT_NAME() {
        return MERCHANT_NAME;
    }

    /**
     * set method 
     *
     * @param MERCHANT_NAME  null
     */
    public void setMERCHANT_NAME(String MERCHANT_NAME) {
        this.MERCHANT_NAME = MERCHANT_NAME == null ? null : MERCHANT_NAME.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.MERCHANT_SHORT_NAME：null
     */
    public String getMERCHANT_SHORT_NAME() {
        return MERCHANT_SHORT_NAME;
    }

    /**
     * set method 
     *
     * @param MERCHANT_SHORT_NAME  null
     */
    public void setMERCHANT_SHORT_NAME(String MERCHANT_SHORT_NAME) {
        this.MERCHANT_SHORT_NAME = MERCHANT_SHORT_NAME == null ? null : MERCHANT_SHORT_NAME.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.BUSINESS_LICENSE_NO：null
     */
    public String getBUSINESS_LICENSE_NO() {
        return BUSINESS_LICENSE_NO;
    }

    /**
     * set method 
     *
     * @param BUSINESS_LICENSE_NO  null
     */
    public void setBUSINESS_LICENSE_NO(String BUSINESS_LICENSE_NO) {
        this.BUSINESS_LICENSE_NO = BUSINESS_LICENSE_NO == null ? null : BUSINESS_LICENSE_NO.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.OPERATOR_NAME：null
     */
    public String getOPERATOR_NAME() {
        return OPERATOR_NAME;
    }

    /**
     * set method 
     *
     * @param OPERATOR_NAME  null
     */
    public void setOPERATOR_NAME(String OPERATOR_NAME) {
        this.OPERATOR_NAME = OPERATOR_NAME == null ? null : OPERATOR_NAME.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.CERT_TYPE：null
     */
    public String getCERT_TYPE() {
        return CERT_TYPE;
    }

    /**
     * set method 
     *
     * @param CERT_TYPE  null
     */
    public void setCERT_TYPE(String CERT_TYPE) {
        this.CERT_TYPE = CERT_TYPE == null ? null : CERT_TYPE.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.CERT_CODE：null
     */
    public String getCERT_CODE() {
        return CERT_CODE;
    }

    /**
     * set method 
     *
     * @param CERT_CODE  null
     */
    public void setCERT_CODE(String CERT_CODE) {
        this.CERT_CODE = CERT_CODE == null ? null : CERT_CODE.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.INDUSTRY_ID_3：null
     */
    public BigDecimal getINDUSTRY_ID_3() {
        return INDUSTRY_ID_3;
    }

    /**
     * set method 
     *
     * @param INDUSTRY_ID_3  null
     */
    public void setINDUSTRY_ID_3(BigDecimal INDUSTRY_ID_3) {
        this.INDUSTRY_ID_3 = INDUSTRY_ID_3;
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.BUSINESS_DISTRICT_ID：null
     */
    public BigDecimal getBUSINESS_DISTRICT_ID() {
        return BUSINESS_DISTRICT_ID;
    }

    /**
     * set method 
     *
     * @param BUSINESS_DISTRICT_ID  null
     */
    public void setBUSINESS_DISTRICT_ID(BigDecimal BUSINESS_DISTRICT_ID) {
        this.BUSINESS_DISTRICT_ID = BUSINESS_DISTRICT_ID;
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.PROVINCE_ID：null
     */
    public BigDecimal getPROVINCE_ID() {
        return PROVINCE_ID;
    }

    /**
     * set method 
     *
     * @param PROVINCE_ID  null
     */
    public void setPROVINCE_ID(BigDecimal PROVINCE_ID) {
        this.PROVINCE_ID = PROVINCE_ID;
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.CITY_ID：null
     */
    public BigDecimal getCITY_ID() {
        return CITY_ID;
    }

    /**
     * set method 
     *
     * @param CITY_ID  null
     */
    public void setCITY_ID(BigDecimal CITY_ID) {
        this.CITY_ID = CITY_ID;
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.DISTRICT_ID：null
     */
    public BigDecimal getDISTRICT_ID() {
        return DISTRICT_ID;
    }

    /**
     * set method 
     *
     * @param DISTRICT_ID  null
     */
    public void setDISTRICT_ID(BigDecimal DISTRICT_ID) {
        this.DISTRICT_ID = DISTRICT_ID;
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.ADDRESS：null
     */
    public String getADDRESS() {
        return ADDRESS;
    }

    /**
     * set method 
     *
     * @param ADDRESS  null
     */
    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS == null ? null : ADDRESS.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.MOBILE_PHONE：null
     */
    public String getMOBILE_PHONE() {
        return MOBILE_PHONE;
    }

    /**
     * set method 
     *
     * @param MOBILE_PHONE  null
     */
    public void setMOBILE_PHONE(String MOBILE_PHONE) {
        this.MOBILE_PHONE = MOBILE_PHONE == null ? null : MOBILE_PHONE.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.FIXED_PHONE：null
     */
    public String getFIXED_PHONE() {
        return FIXED_PHONE;
    }

    /**
     * set method 
     *
     * @param FIXED_PHONE  null
     */
    public void setFIXED_PHONE(String FIXED_PHONE) {
        this.FIXED_PHONE = FIXED_PHONE == null ? null : FIXED_PHONE.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.CONCERN_TYPE：null
     */
    public String getCONCERN_TYPE() {
        return CONCERN_TYPE;
    }

    /**
     * set method 
     *
     * @param CONCERN_TYPE  null
     */
    public void setCONCERN_TYPE(String CONCERN_TYPE) {
        this.CONCERN_TYPE = CONCERN_TYPE == null ? null : CONCERN_TYPE.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.MERCHANT_TYPE：null
     */
    public String getMERCHANT_TYPE() {
        return MERCHANT_TYPE;
    }

    /**
     * set method 
     *
     * @param MERCHANT_TYPE  null
     */
    public void setMERCHANT_TYPE(String MERCHANT_TYPE) {
        this.MERCHANT_TYPE = MERCHANT_TYPE == null ? null : MERCHANT_TYPE.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.EMAIL：null
     */
    public String getEMAIL() {
        return EMAIL;
    }

    /**
     * set method 
     *
     * @param EMAIL  null
     */
    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL == null ? null : EMAIL.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.HOME_PAGE：null
     */
    public String getHOME_PAGE() {
        return HOME_PAGE;
    }

    /**
     * set method 
     *
     * @param HOME_PAGE  null
     */
    public void setHOME_PAGE(String HOME_PAGE) {
        this.HOME_PAGE = HOME_PAGE == null ? null : HOME_PAGE.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.REMARK：null
     */
    public String getREMARK() {
        return REMARK;
    }

    /**
     * set method 
     *
     * @param REMARK  null
     */
    public void setREMARK(String REMARK) {
        this.REMARK = REMARK == null ? null : REMARK.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.BANK_CODE：null
     */
    public String getBANK_CODE() {
        return BANK_CODE;
    }

    /**
     * set method 
     *
     * @param BANK_CODE  null
     */
    public void setBANK_CODE(String BANK_CODE) {
        this.BANK_CODE = BANK_CODE == null ? null : BANK_CODE.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.ACCT_NAME：null
     */
    public String getACCT_NAME() {
        return ACCT_NAME;
    }

    /**
     * set method 
     *
     * @param ACCT_NAME  null
     */
    public void setACCT_NAME(String ACCT_NAME) {
        this.ACCT_NAME = ACCT_NAME == null ? null : ACCT_NAME.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.ACCT_NO：null
     */
    public BigDecimal getACCT_NO() {
        return ACCT_NO;
    }

    /**
     * set method 
     *
     * @param ACCT_NO  null
     */
    public void setACCT_NO(BigDecimal ACCT_NO) {
        this.ACCT_NO = ACCT_NO;
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.ACCT_TYPE：null
     */
    public String getACCT_TYPE() {
        return ACCT_TYPE;
    }

    /**
     * set method 
     *
     * @param ACCT_TYPE  null
     */
    public void setACCT_TYPE(String ACCT_TYPE) {
        this.ACCT_TYPE = ACCT_TYPE == null ? null : ACCT_TYPE.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.NATIVE_FLAG：null
     */
    public String getNATIVE_FLAG() {
        return NATIVE_FLAG;
    }

    /**
     * set method 
     *
     * @param NATIVE_FLAG  null
     */
    public void setNATIVE_FLAG(String NATIVE_FLAG) {
        this.NATIVE_FLAG = NATIVE_FLAG == null ? null : NATIVE_FLAG.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.RATE_ID：null
     */
    public BigDecimal getRATE_ID() {
        return RATE_ID;
    }

    /**
     * set method 
     *
     * @param RATE_ID  null
     */
    public void setRATE_ID(BigDecimal RATE_ID) {
        this.RATE_ID = RATE_ID;
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.SETTL_CYCLE_CODE：null
     */
    public String getSETTL_CYCLE_CODE() {
        return SETTL_CYCLE_CODE;
    }

    /**
     * set method 
     *
     * @param SETTL_CYCLE_CODE  null
     */
    public void setSETTL_CYCLE_CODE(String SETTL_CYCLE_CODE) {
        this.SETTL_CYCLE_CODE = SETTL_CYCLE_CODE == null ? null : SETTL_CYCLE_CODE.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.INDEPENDENT_ACCOUNTING：null
     */
    public String getINDEPENDENT_ACCOUNTING() {
        return INDEPENDENT_ACCOUNTING;
    }

    /**
     * set method 
     *
     * @param INDEPENDENT_ACCOUNTING  null
     */
    public void setINDEPENDENT_ACCOUNTING(String INDEPENDENT_ACCOUNTING) {
        this.INDEPENDENT_ACCOUNTING = INDEPENDENT_ACCOUNTING == null ? null : INDEPENDENT_ACCOUNTING.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.RESERVE_NO：null
     */
    public BigDecimal getRESERVE_NO() {
        return RESERVE_NO;
    }

    /**
     * set method 
     *
     * @param RESERVE_NO  null
     */
    public void setRESERVE_NO(BigDecimal RESERVE_NO) {
        this.RESERVE_NO = RESERVE_NO;
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.RECOMMENDER：null
     */
    public BigDecimal getRECOMMENDER() {
        return RECOMMENDER;
    }

    /**
     * set method 
     *
     * @param RECOMMENDER  null
     */
    public void setRECOMMENDER(BigDecimal RECOMMENDER) {
        this.RECOMMENDER = RECOMMENDER;
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.MCC_ID：null
     */
    public BigDecimal getMCC_ID() {
        return MCC_ID;
    }

    /**
     * set method 
     *
     * @param MCC_ID  null
     */
    public void setMCC_ID(BigDecimal MCC_ID) {
        this.MCC_ID = MCC_ID;
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.URL_BUSINESS_LICENCE：null
     */
    public String getURL_BUSINESS_LICENCE() {
        return URL_BUSINESS_LICENCE;
    }

    /**
     * set method 
     *
     * @param URL_BUSINESS_LICENCE  null
     */
    public void setURL_BUSINESS_LICENCE(String URL_BUSINESS_LICENCE) {
        this.URL_BUSINESS_LICENCE = URL_BUSINESS_LICENCE == null ? null : URL_BUSINESS_LICENCE.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.URL_ORG_CODE_CERT：null
     */
    public String getURL_ORG_CODE_CERT() {
        return URL_ORG_CODE_CERT;
    }

    /**
     * set method 
     *
     * @param URL_ORG_CODE_CERT  null
     */
    public void setURL_ORG_CODE_CERT(String URL_ORG_CODE_CERT) {
        this.URL_ORG_CODE_CERT = URL_ORG_CODE_CERT == null ? null : URL_ORG_CODE_CERT.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.URL_TAX_REG_CERT：null
     */
    public String getURL_TAX_REG_CERT() {
        return URL_TAX_REG_CERT;
    }

    /**
     * set method 
     *
     * @param URL_TAX_REG_CERT  null
     */
    public void setURL_TAX_REG_CERT(String URL_TAX_REG_CERT) {
        this.URL_TAX_REG_CERT = URL_TAX_REG_CERT == null ? null : URL_TAX_REG_CERT.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.URL_OPEN_ACCOUNT_CERT：null
     */
    public String getURL_OPEN_ACCOUNT_CERT() {
        return URL_OPEN_ACCOUNT_CERT;
    }

    /**
     * set method 
     *
     * @param URL_OPEN_ACCOUNT_CERT  null
     */
    public void setURL_OPEN_ACCOUNT_CERT(String URL_OPEN_ACCOUNT_CERT) {
        this.URL_OPEN_ACCOUNT_CERT = URL_OPEN_ACCOUNT_CERT == null ? null : URL_OPEN_ACCOUNT_CERT.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.URL_SETTL_ACCOUNT：null
     */
    public String getURL_SETTL_ACCOUNT() {
        return URL_SETTL_ACCOUNT;
    }

    /**
     * set method 
     *
     * @param URL_SETTL_ACCOUNT  null
     */
    public void setURL_SETTL_ACCOUNT(String URL_SETTL_ACCOUNT) {
        this.URL_SETTL_ACCOUNT = URL_SETTL_ACCOUNT == null ? null : URL_SETTL_ACCOUNT.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.URL_PERSON_PHOTO：null
     */
    public String getURL_PERSON_PHOTO() {
        return URL_PERSON_PHOTO;
    }

    /**
     * set method 
     *
     * @param URL_PERSON_PHOTO  null
     */
    public void setURL_PERSON_PHOTO(String URL_PERSON_PHOTO) {
        this.URL_PERSON_PHOTO = URL_PERSON_PHOTO == null ? null : URL_PERSON_PHOTO.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.URL_ID_CARD1：null
     */
    public String getURL_ID_CARD1() {
        return URL_ID_CARD1;
    }

    /**
     * set method 
     *
     * @param URL_ID_CARD1  null
     */
    public void setURL_ID_CARD1(String URL_ID_CARD1) {
        this.URL_ID_CARD1 = URL_ID_CARD1 == null ? null : URL_ID_CARD1.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.URL_ID_CARD2：null
     */
    public String getURL_ID_CARD2() {
        return URL_ID_CARD2;
    }

    /**
     * set method 
     *
     * @param URL_ID_CARD2  null
     */
    public void setURL_ID_CARD2(String URL_ID_CARD2) {
        this.URL_ID_CARD2 = URL_ID_CARD2 == null ? null : URL_ID_CARD2.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.URL_SHOP_PIC1：null
     */
    public String getURL_SHOP_PIC1() {
        return URL_SHOP_PIC1;
    }

    /**
     * set method 
     *
     * @param URL_SHOP_PIC1  null
     */
    public void setURL_SHOP_PIC1(String URL_SHOP_PIC1) {
        this.URL_SHOP_PIC1 = URL_SHOP_PIC1 == null ? null : URL_SHOP_PIC1.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.URL_SHOP_PIC2：null
     */
    public String getURL_SHOP_PIC2() {
        return URL_SHOP_PIC2;
    }

    /**
     * set method 
     *
     * @param URL_SHOP_PIC2  null
     */
    public void setURL_SHOP_PIC2(String URL_SHOP_PIC2) {
        this.URL_SHOP_PIC2 = URL_SHOP_PIC2 == null ? null : URL_SHOP_PIC2.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.URL_MERCHANT_AGREEMENT：null
     */
    public String getURL_MERCHANT_AGREEMENT() {
        return URL_MERCHANT_AGREEMENT;
    }

    /**
     * set method 
     *
     * @param URL_MERCHANT_AGREEMENT  null
     */
    public void setURL_MERCHANT_AGREEMENT(String URL_MERCHANT_AGREEMENT) {
        this.URL_MERCHANT_AGREEMENT = URL_MERCHANT_AGREEMENT == null ? null : URL_MERCHANT_AGREEMENT.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.URL_APPLICATION_FORM：null
     */
    public String getURL_APPLICATION_FORM() {
        return URL_APPLICATION_FORM;
    }

    /**
     * set method 
     *
     * @param URL_APPLICATION_FORM  null
     */
    public void setURL_APPLICATION_FORM(String URL_APPLICATION_FORM) {
        this.URL_APPLICATION_FORM = URL_APPLICATION_FORM == null ? null : URL_APPLICATION_FORM.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.URL_MERCHANT_COMM_LETTER：null
     */
    public String getURL_MERCHANT_COMM_LETTER() {
        return URL_MERCHANT_COMM_LETTER;
    }

    /**
     * set method 
     *
     * @param URL_MERCHANT_COMM_LETTER  null
     */
    public void setURL_MERCHANT_COMM_LETTER(String URL_MERCHANT_COMM_LETTER) {
        this.URL_MERCHANT_COMM_LETTER = URL_MERCHANT_COMM_LETTER == null ? null : URL_MERCHANT_COMM_LETTER.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.URL_AUTH_BOOK：null
     */
    public String getURL_AUTH_BOOK() {
        return URL_AUTH_BOOK;
    }

    /**
     * set method 
     *
     * @param URL_AUTH_BOOK  null
     */
    public void setURL_AUTH_BOOK(String URL_AUTH_BOOK) {
        this.URL_AUTH_BOOK = URL_AUTH_BOOK == null ? null : URL_AUTH_BOOK.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.URL_OTHER_AGREEMENT：null
     */
    public String getURL_OTHER_AGREEMENT() {
        return URL_OTHER_AGREEMENT;
    }

    /**
     * set method 
     *
     * @param URL_OTHER_AGREEMENT  null
     */
    public void setURL_OTHER_AGREEMENT(String URL_OTHER_AGREEMENT) {
        this.URL_OTHER_AGREEMENT = URL_OTHER_AGREEMENT == null ? null : URL_OTHER_AGREEMENT.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.MERCHANT_REMARK：null
     */
    public String getMERCHANT_REMARK() {
        return MERCHANT_REMARK;
    }

    /**
     * set method 
     *
     * @param MERCHANT_REMARK  null
     */
    public void setMERCHANT_REMARK(String MERCHANT_REMARK) {
        this.MERCHANT_REMARK = MERCHANT_REMARK == null ? null : MERCHANT_REMARK.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.MODIFY_ID：null
     */
    public BigDecimal getMODIFY_ID() {
        return MODIFY_ID;
    }

    /**
     * set method 
     *
     * @param MODIFY_ID  null
     */
    public void setMODIFY_ID(BigDecimal MODIFY_ID) {
        this.MODIFY_ID = MODIFY_ID;
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.MODIFY_TIME：null
     */
    public Date getMODIFY_TIME() {
        return MODIFY_TIME;
    }

    /**
     * set method 
     *
     * @param MODIFY_TIME  null
     */
    public void setMODIFY_TIME(Date MODIFY_TIME) {
        this.MODIFY_TIME = MODIFY_TIME;
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.CREATED_ID：null
     */
    public BigDecimal getCREATED_ID() {
        return CREATED_ID;
    }

    /**
     * set method 
     *
     * @param CREATED_ID  null
     */
    public void setCREATED_ID(BigDecimal CREATED_ID) {
        this.CREATED_ID = CREATED_ID;
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.CREATED_TIME：null
     */
    public Date getCREATED_TIME() {
        return CREATED_TIME;
    }

    /**
     * set method 
     *
     * @param CREATED_TIME  null
     */
    public void setCREATED_TIME(Date CREATED_TIME) {
        this.CREATED_TIME = CREATED_TIME;
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.UPDATED_ID：null
     */
    public BigDecimal getUPDATED_ID() {
        return UPDATED_ID;
    }

    /**
     * set method 
     *
     * @param UPDATED_ID  null
     */
    public void setUPDATED_ID(BigDecimal UPDATED_ID) {
        this.UPDATED_ID = UPDATED_ID;
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_BASIC_INFO.UPDATED_TIME：null
     */
    public Date getUPDATED_TIME() {
        return UPDATED_TIME;
    }

    /**
     * set method 
     *
     * @param UPDATED_TIME  null
     */
    public void setUPDATED_TIME(Date UPDATED_TIME) {
        this.UPDATED_TIME = UPDATED_TIME;
    }

    /**
     *
     * @param that
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        T_merchant_basic_info other = (T_merchant_basic_info) that;
        return (this.getID() == null ? other.getID() == null : this.getID().equals(other.getID()))
            && (this.getMERCHANT_ID() == null ? other.getMERCHANT_ID() == null : this.getMERCHANT_ID().equals(other.getMERCHANT_ID()))
            && (this.getMERCHANT_CODE() == null ? other.getMERCHANT_CODE() == null : this.getMERCHANT_CODE().equals(other.getMERCHANT_CODE()))
            && (this.getTHREE_IN_ONE_CERT() == null ? other.getTHREE_IN_ONE_CERT() == null : this.getTHREE_IN_ONE_CERT().equals(other.getTHREE_IN_ONE_CERT()))
            && (this.getMERCHANT_NAME() == null ? other.getMERCHANT_NAME() == null : this.getMERCHANT_NAME().equals(other.getMERCHANT_NAME()))
            && (this.getMERCHANT_SHORT_NAME() == null ? other.getMERCHANT_SHORT_NAME() == null : this.getMERCHANT_SHORT_NAME().equals(other.getMERCHANT_SHORT_NAME()))
            && (this.getBUSINESS_LICENSE_NO() == null ? other.getBUSINESS_LICENSE_NO() == null : this.getBUSINESS_LICENSE_NO().equals(other.getBUSINESS_LICENSE_NO()))
            && (this.getOPERATOR_NAME() == null ? other.getOPERATOR_NAME() == null : this.getOPERATOR_NAME().equals(other.getOPERATOR_NAME()))
            && (this.getCERT_TYPE() == null ? other.getCERT_TYPE() == null : this.getCERT_TYPE().equals(other.getCERT_TYPE()))
            && (this.getCERT_CODE() == null ? other.getCERT_CODE() == null : this.getCERT_CODE().equals(other.getCERT_CODE()))
            && (this.getINDUSTRY_ID_3() == null ? other.getINDUSTRY_ID_3() == null : this.getINDUSTRY_ID_3().equals(other.getINDUSTRY_ID_3()))
            && (this.getBUSINESS_DISTRICT_ID() == null ? other.getBUSINESS_DISTRICT_ID() == null : this.getBUSINESS_DISTRICT_ID().equals(other.getBUSINESS_DISTRICT_ID()))
            && (this.getPROVINCE_ID() == null ? other.getPROVINCE_ID() == null : this.getPROVINCE_ID().equals(other.getPROVINCE_ID()))
            && (this.getCITY_ID() == null ? other.getCITY_ID() == null : this.getCITY_ID().equals(other.getCITY_ID()))
            && (this.getDISTRICT_ID() == null ? other.getDISTRICT_ID() == null : this.getDISTRICT_ID().equals(other.getDISTRICT_ID()))
            && (this.getADDRESS() == null ? other.getADDRESS() == null : this.getADDRESS().equals(other.getADDRESS()))
            && (this.getMOBILE_PHONE() == null ? other.getMOBILE_PHONE() == null : this.getMOBILE_PHONE().equals(other.getMOBILE_PHONE()))
            && (this.getFIXED_PHONE() == null ? other.getFIXED_PHONE() == null : this.getFIXED_PHONE().equals(other.getFIXED_PHONE()))
            && (this.getCONCERN_TYPE() == null ? other.getCONCERN_TYPE() == null : this.getCONCERN_TYPE().equals(other.getCONCERN_TYPE()))
            && (this.getMERCHANT_TYPE() == null ? other.getMERCHANT_TYPE() == null : this.getMERCHANT_TYPE().equals(other.getMERCHANT_TYPE()))
            && (this.getEMAIL() == null ? other.getEMAIL() == null : this.getEMAIL().equals(other.getEMAIL()))
            && (this.getHOME_PAGE() == null ? other.getHOME_PAGE() == null : this.getHOME_PAGE().equals(other.getHOME_PAGE()))
            && (this.getREMARK() == null ? other.getREMARK() == null : this.getREMARK().equals(other.getREMARK()))
            && (this.getBANK_CODE() == null ? other.getBANK_CODE() == null : this.getBANK_CODE().equals(other.getBANK_CODE()))
            && (this.getACCT_NAME() == null ? other.getACCT_NAME() == null : this.getACCT_NAME().equals(other.getACCT_NAME()))
            && (this.getACCT_NO() == null ? other.getACCT_NO() == null : this.getACCT_NO().equals(other.getACCT_NO()))
            && (this.getACCT_TYPE() == null ? other.getACCT_TYPE() == null : this.getACCT_TYPE().equals(other.getACCT_TYPE()))
            && (this.getNATIVE_FLAG() == null ? other.getNATIVE_FLAG() == null : this.getNATIVE_FLAG().equals(other.getNATIVE_FLAG()))
            && (this.getRATE_ID() == null ? other.getRATE_ID() == null : this.getRATE_ID().equals(other.getRATE_ID()))
            && (this.getSETTL_CYCLE_CODE() == null ? other.getSETTL_CYCLE_CODE() == null : this.getSETTL_CYCLE_CODE().equals(other.getSETTL_CYCLE_CODE()))
            && (this.getINDEPENDENT_ACCOUNTING() == null ? other.getINDEPENDENT_ACCOUNTING() == null : this.getINDEPENDENT_ACCOUNTING().equals(other.getINDEPENDENT_ACCOUNTING()))
            && (this.getRESERVE_NO() == null ? other.getRESERVE_NO() == null : this.getRESERVE_NO().equals(other.getRESERVE_NO()))
            && (this.getRECOMMENDER() == null ? other.getRECOMMENDER() == null : this.getRECOMMENDER().equals(other.getRECOMMENDER()))
            && (this.getMCC_ID() == null ? other.getMCC_ID() == null : this.getMCC_ID().equals(other.getMCC_ID()))
            && (this.getURL_BUSINESS_LICENCE() == null ? other.getURL_BUSINESS_LICENCE() == null : this.getURL_BUSINESS_LICENCE().equals(other.getURL_BUSINESS_LICENCE()))
            && (this.getURL_ORG_CODE_CERT() == null ? other.getURL_ORG_CODE_CERT() == null : this.getURL_ORG_CODE_CERT().equals(other.getURL_ORG_CODE_CERT()))
            && (this.getURL_TAX_REG_CERT() == null ? other.getURL_TAX_REG_CERT() == null : this.getURL_TAX_REG_CERT().equals(other.getURL_TAX_REG_CERT()))
            && (this.getURL_OPEN_ACCOUNT_CERT() == null ? other.getURL_OPEN_ACCOUNT_CERT() == null : this.getURL_OPEN_ACCOUNT_CERT().equals(other.getURL_OPEN_ACCOUNT_CERT()))
            && (this.getURL_SETTL_ACCOUNT() == null ? other.getURL_SETTL_ACCOUNT() == null : this.getURL_SETTL_ACCOUNT().equals(other.getURL_SETTL_ACCOUNT()))
            && (this.getURL_PERSON_PHOTO() == null ? other.getURL_PERSON_PHOTO() == null : this.getURL_PERSON_PHOTO().equals(other.getURL_PERSON_PHOTO()))
            && (this.getURL_ID_CARD1() == null ? other.getURL_ID_CARD1() == null : this.getURL_ID_CARD1().equals(other.getURL_ID_CARD1()))
            && (this.getURL_ID_CARD2() == null ? other.getURL_ID_CARD2() == null : this.getURL_ID_CARD2().equals(other.getURL_ID_CARD2()))
            && (this.getURL_SHOP_PIC1() == null ? other.getURL_SHOP_PIC1() == null : this.getURL_SHOP_PIC1().equals(other.getURL_SHOP_PIC1()))
            && (this.getURL_SHOP_PIC2() == null ? other.getURL_SHOP_PIC2() == null : this.getURL_SHOP_PIC2().equals(other.getURL_SHOP_PIC2()))
            && (this.getURL_MERCHANT_AGREEMENT() == null ? other.getURL_MERCHANT_AGREEMENT() == null : this.getURL_MERCHANT_AGREEMENT().equals(other.getURL_MERCHANT_AGREEMENT()))
            && (this.getURL_APPLICATION_FORM() == null ? other.getURL_APPLICATION_FORM() == null : this.getURL_APPLICATION_FORM().equals(other.getURL_APPLICATION_FORM()))
            && (this.getURL_MERCHANT_COMM_LETTER() == null ? other.getURL_MERCHANT_COMM_LETTER() == null : this.getURL_MERCHANT_COMM_LETTER().equals(other.getURL_MERCHANT_COMM_LETTER()))
            && (this.getURL_AUTH_BOOK() == null ? other.getURL_AUTH_BOOK() == null : this.getURL_AUTH_BOOK().equals(other.getURL_AUTH_BOOK()))
            && (this.getURL_OTHER_AGREEMENT() == null ? other.getURL_OTHER_AGREEMENT() == null : this.getURL_OTHER_AGREEMENT().equals(other.getURL_OTHER_AGREEMENT()))
            && (this.getMERCHANT_REMARK() == null ? other.getMERCHANT_REMARK() == null : this.getMERCHANT_REMARK().equals(other.getMERCHANT_REMARK()))
            && (this.getMODIFY_ID() == null ? other.getMODIFY_ID() == null : this.getMODIFY_ID().equals(other.getMODIFY_ID()))
            && (this.getMODIFY_TIME() == null ? other.getMODIFY_TIME() == null : this.getMODIFY_TIME().equals(other.getMODIFY_TIME()))
            && (this.getCREATED_ID() == null ? other.getCREATED_ID() == null : this.getCREATED_ID().equals(other.getCREATED_ID()))
            && (this.getCREATED_TIME() == null ? other.getCREATED_TIME() == null : this.getCREATED_TIME().equals(other.getCREATED_TIME()))
            && (this.getUPDATED_ID() == null ? other.getUPDATED_ID() == null : this.getUPDATED_ID().equals(other.getUPDATED_ID()))
            && (this.getUPDATED_TIME() == null ? other.getUPDATED_TIME() == null : this.getUPDATED_TIME().equals(other.getUPDATED_TIME()));
    }

    /**
     *
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getID() == null) ? 0 : getID().hashCode());
        result = prime * result + ((getMERCHANT_ID() == null) ? 0 : getMERCHANT_ID().hashCode());
        result = prime * result + ((getMERCHANT_CODE() == null) ? 0 : getMERCHANT_CODE().hashCode());
        result = prime * result + ((getTHREE_IN_ONE_CERT() == null) ? 0 : getTHREE_IN_ONE_CERT().hashCode());
        result = prime * result + ((getMERCHANT_NAME() == null) ? 0 : getMERCHANT_NAME().hashCode());
        result = prime * result + ((getMERCHANT_SHORT_NAME() == null) ? 0 : getMERCHANT_SHORT_NAME().hashCode());
        result = prime * result + ((getBUSINESS_LICENSE_NO() == null) ? 0 : getBUSINESS_LICENSE_NO().hashCode());
        result = prime * result + ((getOPERATOR_NAME() == null) ? 0 : getOPERATOR_NAME().hashCode());
        result = prime * result + ((getCERT_TYPE() == null) ? 0 : getCERT_TYPE().hashCode());
        result = prime * result + ((getCERT_CODE() == null) ? 0 : getCERT_CODE().hashCode());
        result = prime * result + ((getINDUSTRY_ID_3() == null) ? 0 : getINDUSTRY_ID_3().hashCode());
        result = prime * result + ((getBUSINESS_DISTRICT_ID() == null) ? 0 : getBUSINESS_DISTRICT_ID().hashCode());
        result = prime * result + ((getPROVINCE_ID() == null) ? 0 : getPROVINCE_ID().hashCode());
        result = prime * result + ((getCITY_ID() == null) ? 0 : getCITY_ID().hashCode());
        result = prime * result + ((getDISTRICT_ID() == null) ? 0 : getDISTRICT_ID().hashCode());
        result = prime * result + ((getADDRESS() == null) ? 0 : getADDRESS().hashCode());
        result = prime * result + ((getMOBILE_PHONE() == null) ? 0 : getMOBILE_PHONE().hashCode());
        result = prime * result + ((getFIXED_PHONE() == null) ? 0 : getFIXED_PHONE().hashCode());
        result = prime * result + ((getCONCERN_TYPE() == null) ? 0 : getCONCERN_TYPE().hashCode());
        result = prime * result + ((getMERCHANT_TYPE() == null) ? 0 : getMERCHANT_TYPE().hashCode());
        result = prime * result + ((getEMAIL() == null) ? 0 : getEMAIL().hashCode());
        result = prime * result + ((getHOME_PAGE() == null) ? 0 : getHOME_PAGE().hashCode());
        result = prime * result + ((getREMARK() == null) ? 0 : getREMARK().hashCode());
        result = prime * result + ((getBANK_CODE() == null) ? 0 : getBANK_CODE().hashCode());
        result = prime * result + ((getACCT_NAME() == null) ? 0 : getACCT_NAME().hashCode());
        result = prime * result + ((getACCT_NO() == null) ? 0 : getACCT_NO().hashCode());
        result = prime * result + ((getACCT_TYPE() == null) ? 0 : getACCT_TYPE().hashCode());
        result = prime * result + ((getNATIVE_FLAG() == null) ? 0 : getNATIVE_FLAG().hashCode());
        result = prime * result + ((getRATE_ID() == null) ? 0 : getRATE_ID().hashCode());
        result = prime * result + ((getSETTL_CYCLE_CODE() == null) ? 0 : getSETTL_CYCLE_CODE().hashCode());
        result = prime * result + ((getINDEPENDENT_ACCOUNTING() == null) ? 0 : getINDEPENDENT_ACCOUNTING().hashCode());
        result = prime * result + ((getRESERVE_NO() == null) ? 0 : getRESERVE_NO().hashCode());
        result = prime * result + ((getRECOMMENDER() == null) ? 0 : getRECOMMENDER().hashCode());
        result = prime * result + ((getMCC_ID() == null) ? 0 : getMCC_ID().hashCode());
        result = prime * result + ((getURL_BUSINESS_LICENCE() == null) ? 0 : getURL_BUSINESS_LICENCE().hashCode());
        result = prime * result + ((getURL_ORG_CODE_CERT() == null) ? 0 : getURL_ORG_CODE_CERT().hashCode());
        result = prime * result + ((getURL_TAX_REG_CERT() == null) ? 0 : getURL_TAX_REG_CERT().hashCode());
        result = prime * result + ((getURL_OPEN_ACCOUNT_CERT() == null) ? 0 : getURL_OPEN_ACCOUNT_CERT().hashCode());
        result = prime * result + ((getURL_SETTL_ACCOUNT() == null) ? 0 : getURL_SETTL_ACCOUNT().hashCode());
        result = prime * result + ((getURL_PERSON_PHOTO() == null) ? 0 : getURL_PERSON_PHOTO().hashCode());
        result = prime * result + ((getURL_ID_CARD1() == null) ? 0 : getURL_ID_CARD1().hashCode());
        result = prime * result + ((getURL_ID_CARD2() == null) ? 0 : getURL_ID_CARD2().hashCode());
        result = prime * result + ((getURL_SHOP_PIC1() == null) ? 0 : getURL_SHOP_PIC1().hashCode());
        result = prime * result + ((getURL_SHOP_PIC2() == null) ? 0 : getURL_SHOP_PIC2().hashCode());
        result = prime * result + ((getURL_MERCHANT_AGREEMENT() == null) ? 0 : getURL_MERCHANT_AGREEMENT().hashCode());
        result = prime * result + ((getURL_APPLICATION_FORM() == null) ? 0 : getURL_APPLICATION_FORM().hashCode());
        result = prime * result + ((getURL_MERCHANT_COMM_LETTER() == null) ? 0 : getURL_MERCHANT_COMM_LETTER().hashCode());
        result = prime * result + ((getURL_AUTH_BOOK() == null) ? 0 : getURL_AUTH_BOOK().hashCode());
        result = prime * result + ((getURL_OTHER_AGREEMENT() == null) ? 0 : getURL_OTHER_AGREEMENT().hashCode());
        result = prime * result + ((getMERCHANT_REMARK() == null) ? 0 : getMERCHANT_REMARK().hashCode());
        result = prime * result + ((getMODIFY_ID() == null) ? 0 : getMODIFY_ID().hashCode());
        result = prime * result + ((getMODIFY_TIME() == null) ? 0 : getMODIFY_TIME().hashCode());
        result = prime * result + ((getCREATED_ID() == null) ? 0 : getCREATED_ID().hashCode());
        result = prime * result + ((getCREATED_TIME() == null) ? 0 : getCREATED_TIME().hashCode());
        result = prime * result + ((getUPDATED_ID() == null) ? 0 : getUPDATED_ID().hashCode());
        result = prime * result + ((getUPDATED_TIME() == null) ? 0 : getUPDATED_TIME().hashCode());
        return result;
    }
}