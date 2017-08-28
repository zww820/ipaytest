package org.ipay.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class T_check_acc_info_sta implements Serializable {
    /**
     * 表 : IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA
     * 对应字段 : ID
     */
    private BigDecimal ID;

    /**
     * 表 : IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA
     * 对应字段 : CHECK_DATE
     */
    private String CHECK_DATE;

    /**
     * 表 : IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA
     * 对应字段 : CHANNEL_ID
     */
    private BigDecimal CHANNEL_ID;

    /**
     * 表 : IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA
     * 对应字段 : CHANNEL_CODE
     */
    private String CHANNEL_CODE;

    /**
     * 表 : IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA
     * 对应字段 : OUR_TRADE_AMOUNT
     */
    private BigDecimal OUR_TRADE_AMOUNT;

    /**
     * 表 : IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA
     * 对应字段 : OUR_REFUND_AMOUNT
     */
    private BigDecimal OUR_REFUND_AMOUNT;

    /**
     * 表 : IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA
     * 对应字段 : OUR_DISCOUNT_AMOUNT
     */
    private BigDecimal OUR_DISCOUNT_AMOUNT;

    /**
     * 表 : IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA
     * 对应字段 : OUR_TRADE_NUM
     */
    private Integer OUR_TRADE_NUM;

    /**
     * 表 : IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA
     * 对应字段 : OUR_REFUND_NUM
     */
    private Integer OUR_REFUND_NUM;

    /**
     * 表 : IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA
     * 对应字段 : CHANNEL_TRADE_AMOUNT
     */
    private BigDecimal CHANNEL_TRADE_AMOUNT;

    /**
     * 表 : IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA
     * 对应字段 : CHANNEL_REFUND_AMOUNT
     */
    private BigDecimal CHANNEL_REFUND_AMOUNT;

    /**
     * 表 : IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA
     * 对应字段 : CHANNEL_DISCOUNT_AMOUNT
     */
    private BigDecimal CHANNEL_DISCOUNT_AMOUNT;

    /**
     * 表 : IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA
     * 对应字段 : CHANNEL_TRADE_FEE
     */
    private BigDecimal CHANNEL_TRADE_FEE;

    /**
     * 表 : IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA
     * 对应字段 : CHANNEL_REFUND_FEE
     */
    private BigDecimal CHANNEL_REFUND_FEE;

    /**
     * 表 : IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA
     * 对应字段 : CHANNEL_TRADE_NUM
     */
    private Integer CHANNEL_TRADE_NUM;

    /**
     * 表 : IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA
     * 对应字段 : CHANNEL_REFUND_NUM
     */
    private Integer CHANNEL_REFUND_NUM;

    /**
     * 表 : IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA
     * 对应字段 : TRADE_EQUAL_AMOUNT
     */
    private BigDecimal TRADE_EQUAL_AMOUNT;

    /**
     * 表 : IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA
     * 对应字段 : REFUND_EQUAL_AMOUNT
     */
    private BigDecimal REFUND_EQUAL_AMOUNT;

    /**
     * 表 : IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA
     * 对应字段 : TRADE_NOEQUAL_AMOUNT
     */
    private BigDecimal TRADE_NOEQUAL_AMOUNT;

    /**
     * 表 : IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA
     * 对应字段 : REFUND_NOEQUAL_AMOUNT
     */
    private BigDecimal REFUND_NOEQUAL_AMOUNT;

    /**
     * 表 : IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA
     * 对应字段 : OUR_TRADE_DIFFER_AMOUNT
     */
    private BigDecimal OUR_TRADE_DIFFER_AMOUNT;

    /**
     * 表 : IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA
     * 对应字段 : CHANNEL_TRADE_DIFFER_AMOUNT
     */
    private BigDecimal CHANNEL_TRADE_DIFFER_AMOUNT;

    /**
     * 表 : IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA
     * 对应字段 : OUR_REFUND_DIFFER_AMOUNT
     */
    private BigDecimal OUR_REFUND_DIFFER_AMOUNT;

    /**
     * 表 : IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA
     * 对应字段 : CHANNEL_REFUND_DIFFER_AMOUNT
     */
    private BigDecimal CHANNEL_REFUND_DIFFER_AMOUNT;

    /**
     * 表 : IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA
     * 对应字段 : TRADE_EQUAL_NUM
     */
    private Integer TRADE_EQUAL_NUM;

    /**
     * 表 : IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA
     * 对应字段 : TRADE_NOEQUAL_NUM
     */
    private Integer TRADE_NOEQUAL_NUM;

    /**
     * 表 : IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA
     * 对应字段 : REFUND_EQUAL_NUM
     */
    private Integer REFUND_EQUAL_NUM;

    /**
     * 表 : IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA
     * 对应字段 : REFUND_NOEQUAL_NUM
     */
    private Integer REFUND_NOEQUAL_NUM;

    /**
     * 表 : IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA
     * 对应字段 : OUR_TRADE_DIFFER_NUM
     */
    private Integer OUR_TRADE_DIFFER_NUM;

    /**
     * 表 : IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA
     * 对应字段 : CHANNEL_TRADE_DIFFER_NUM
     */
    private Integer CHANNEL_TRADE_DIFFER_NUM;

    /**
     * 表 : IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA
     * 对应字段 : OUR_REFUND_DIFFER_NUM
     */
    private Integer OUR_REFUND_DIFFER_NUM;

    /**
     * 表 : IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA
     * 对应字段 : CHANNEL_REFUND_DIFFER_NUM
     */
    private Integer CHANNEL_REFUND_DIFFER_NUM;

    /**
     * 表 : IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA
     * 对应字段 : RESULT_STATUS
     */
    private String RESULT_STATUS;

    /**
     * 表 : IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA
     * 对应字段 : CREATED_TIME
     */
    private Date CREATED_TIME;

    /**
     * 表 : IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA
     * 对应字段 : UPDATED_TIME
     */
    private Date UPDATED_TIME;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA
     *
     * @MBG Generated Mon Aug 07 19:43:33 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA.ID：null
     */
    public BigDecimal getID() {
        return ID;
    }

    /**
     * set method 
     *
     * @param ID  null
     */
    public void setID(BigDecimal ID) {
        this.ID = ID;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA.CHECK_DATE：null
     */
    public String getCHECK_DATE() {
        return CHECK_DATE;
    }

    /**
     * set method 
     *
     * @param CHECK_DATE  null
     */
    public void setCHECK_DATE(String CHECK_DATE) {
        this.CHECK_DATE = CHECK_DATE == null ? null : CHECK_DATE.trim();
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA.CHANNEL_ID：null
     */
    public BigDecimal getCHANNEL_ID() {
        return CHANNEL_ID;
    }

    /**
     * set method 
     *
     * @param CHANNEL_ID  null
     */
    public void setCHANNEL_ID(BigDecimal CHANNEL_ID) {
        this.CHANNEL_ID = CHANNEL_ID;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA.CHANNEL_CODE：null
     */
    public String getCHANNEL_CODE() {
        return CHANNEL_CODE;
    }

    /**
     * set method 
     *
     * @param CHANNEL_CODE  null
     */
    public void setCHANNEL_CODE(String CHANNEL_CODE) {
        this.CHANNEL_CODE = CHANNEL_CODE == null ? null : CHANNEL_CODE.trim();
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA.OUR_TRADE_AMOUNT：null
     */
    public BigDecimal getOUR_TRADE_AMOUNT() {
        return OUR_TRADE_AMOUNT;
    }

    /**
     * set method 
     *
     * @param OUR_TRADE_AMOUNT  null
     */
    public void setOUR_TRADE_AMOUNT(BigDecimal OUR_TRADE_AMOUNT) {
        this.OUR_TRADE_AMOUNT = OUR_TRADE_AMOUNT;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA.OUR_REFUND_AMOUNT：null
     */
    public BigDecimal getOUR_REFUND_AMOUNT() {
        return OUR_REFUND_AMOUNT;
    }

    /**
     * set method 
     *
     * @param OUR_REFUND_AMOUNT  null
     */
    public void setOUR_REFUND_AMOUNT(BigDecimal OUR_REFUND_AMOUNT) {
        this.OUR_REFUND_AMOUNT = OUR_REFUND_AMOUNT;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA.OUR_DISCOUNT_AMOUNT：null
     */
    public BigDecimal getOUR_DISCOUNT_AMOUNT() {
        return OUR_DISCOUNT_AMOUNT;
    }

    /**
     * set method 
     *
     * @param OUR_DISCOUNT_AMOUNT  null
     */
    public void setOUR_DISCOUNT_AMOUNT(BigDecimal OUR_DISCOUNT_AMOUNT) {
        this.OUR_DISCOUNT_AMOUNT = OUR_DISCOUNT_AMOUNT;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA.OUR_TRADE_NUM：null
     */
    public Integer getOUR_TRADE_NUM() {
        return OUR_TRADE_NUM;
    }

    /**
     * set method 
     *
     * @param OUR_TRADE_NUM  null
     */
    public void setOUR_TRADE_NUM(Integer OUR_TRADE_NUM) {
        this.OUR_TRADE_NUM = OUR_TRADE_NUM;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA.OUR_REFUND_NUM：null
     */
    public Integer getOUR_REFUND_NUM() {
        return OUR_REFUND_NUM;
    }

    /**
     * set method 
     *
     * @param OUR_REFUND_NUM  null
     */
    public void setOUR_REFUND_NUM(Integer OUR_REFUND_NUM) {
        this.OUR_REFUND_NUM = OUR_REFUND_NUM;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA.CHANNEL_TRADE_AMOUNT：null
     */
    public BigDecimal getCHANNEL_TRADE_AMOUNT() {
        return CHANNEL_TRADE_AMOUNT;
    }

    /**
     * set method 
     *
     * @param CHANNEL_TRADE_AMOUNT  null
     */
    public void setCHANNEL_TRADE_AMOUNT(BigDecimal CHANNEL_TRADE_AMOUNT) {
        this.CHANNEL_TRADE_AMOUNT = CHANNEL_TRADE_AMOUNT;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA.CHANNEL_REFUND_AMOUNT：null
     */
    public BigDecimal getCHANNEL_REFUND_AMOUNT() {
        return CHANNEL_REFUND_AMOUNT;
    }

    /**
     * set method 
     *
     * @param CHANNEL_REFUND_AMOUNT  null
     */
    public void setCHANNEL_REFUND_AMOUNT(BigDecimal CHANNEL_REFUND_AMOUNT) {
        this.CHANNEL_REFUND_AMOUNT = CHANNEL_REFUND_AMOUNT;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA.CHANNEL_DISCOUNT_AMOUNT：null
     */
    public BigDecimal getCHANNEL_DISCOUNT_AMOUNT() {
        return CHANNEL_DISCOUNT_AMOUNT;
    }

    /**
     * set method 
     *
     * @param CHANNEL_DISCOUNT_AMOUNT  null
     */
    public void setCHANNEL_DISCOUNT_AMOUNT(BigDecimal CHANNEL_DISCOUNT_AMOUNT) {
        this.CHANNEL_DISCOUNT_AMOUNT = CHANNEL_DISCOUNT_AMOUNT;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA.CHANNEL_TRADE_FEE：null
     */
    public BigDecimal getCHANNEL_TRADE_FEE() {
        return CHANNEL_TRADE_FEE;
    }

    /**
     * set method 
     *
     * @param CHANNEL_TRADE_FEE  null
     */
    public void setCHANNEL_TRADE_FEE(BigDecimal CHANNEL_TRADE_FEE) {
        this.CHANNEL_TRADE_FEE = CHANNEL_TRADE_FEE;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA.CHANNEL_REFUND_FEE：null
     */
    public BigDecimal getCHANNEL_REFUND_FEE() {
        return CHANNEL_REFUND_FEE;
    }

    /**
     * set method 
     *
     * @param CHANNEL_REFUND_FEE  null
     */
    public void setCHANNEL_REFUND_FEE(BigDecimal CHANNEL_REFUND_FEE) {
        this.CHANNEL_REFUND_FEE = CHANNEL_REFUND_FEE;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA.CHANNEL_TRADE_NUM：null
     */
    public Integer getCHANNEL_TRADE_NUM() {
        return CHANNEL_TRADE_NUM;
    }

    /**
     * set method 
     *
     * @param CHANNEL_TRADE_NUM  null
     */
    public void setCHANNEL_TRADE_NUM(Integer CHANNEL_TRADE_NUM) {
        this.CHANNEL_TRADE_NUM = CHANNEL_TRADE_NUM;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA.CHANNEL_REFUND_NUM：null
     */
    public Integer getCHANNEL_REFUND_NUM() {
        return CHANNEL_REFUND_NUM;
    }

    /**
     * set method 
     *
     * @param CHANNEL_REFUND_NUM  null
     */
    public void setCHANNEL_REFUND_NUM(Integer CHANNEL_REFUND_NUM) {
        this.CHANNEL_REFUND_NUM = CHANNEL_REFUND_NUM;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA.TRADE_EQUAL_AMOUNT：null
     */
    public BigDecimal getTRADE_EQUAL_AMOUNT() {
        return TRADE_EQUAL_AMOUNT;
    }

    /**
     * set method 
     *
     * @param TRADE_EQUAL_AMOUNT  null
     */
    public void setTRADE_EQUAL_AMOUNT(BigDecimal TRADE_EQUAL_AMOUNT) {
        this.TRADE_EQUAL_AMOUNT = TRADE_EQUAL_AMOUNT;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA.REFUND_EQUAL_AMOUNT：null
     */
    public BigDecimal getREFUND_EQUAL_AMOUNT() {
        return REFUND_EQUAL_AMOUNT;
    }

    /**
     * set method 
     *
     * @param REFUND_EQUAL_AMOUNT  null
     */
    public void setREFUND_EQUAL_AMOUNT(BigDecimal REFUND_EQUAL_AMOUNT) {
        this.REFUND_EQUAL_AMOUNT = REFUND_EQUAL_AMOUNT;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA.TRADE_NOEQUAL_AMOUNT：null
     */
    public BigDecimal getTRADE_NOEQUAL_AMOUNT() {
        return TRADE_NOEQUAL_AMOUNT;
    }

    /**
     * set method 
     *
     * @param TRADE_NOEQUAL_AMOUNT  null
     */
    public void setTRADE_NOEQUAL_AMOUNT(BigDecimal TRADE_NOEQUAL_AMOUNT) {
        this.TRADE_NOEQUAL_AMOUNT = TRADE_NOEQUAL_AMOUNT;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA.REFUND_NOEQUAL_AMOUNT：null
     */
    public BigDecimal getREFUND_NOEQUAL_AMOUNT() {
        return REFUND_NOEQUAL_AMOUNT;
    }

    /**
     * set method 
     *
     * @param REFUND_NOEQUAL_AMOUNT  null
     */
    public void setREFUND_NOEQUAL_AMOUNT(BigDecimal REFUND_NOEQUAL_AMOUNT) {
        this.REFUND_NOEQUAL_AMOUNT = REFUND_NOEQUAL_AMOUNT;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA.OUR_TRADE_DIFFER_AMOUNT：null
     */
    public BigDecimal getOUR_TRADE_DIFFER_AMOUNT() {
        return OUR_TRADE_DIFFER_AMOUNT;
    }

    /**
     * set method 
     *
     * @param OUR_TRADE_DIFFER_AMOUNT  null
     */
    public void setOUR_TRADE_DIFFER_AMOUNT(BigDecimal OUR_TRADE_DIFFER_AMOUNT) {
        this.OUR_TRADE_DIFFER_AMOUNT = OUR_TRADE_DIFFER_AMOUNT;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA.CHANNEL_TRADE_DIFFER_AMOUNT：null
     */
    public BigDecimal getCHANNEL_TRADE_DIFFER_AMOUNT() {
        return CHANNEL_TRADE_DIFFER_AMOUNT;
    }

    /**
     * set method 
     *
     * @param CHANNEL_TRADE_DIFFER_AMOUNT  null
     */
    public void setCHANNEL_TRADE_DIFFER_AMOUNT(BigDecimal CHANNEL_TRADE_DIFFER_AMOUNT) {
        this.CHANNEL_TRADE_DIFFER_AMOUNT = CHANNEL_TRADE_DIFFER_AMOUNT;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA.OUR_REFUND_DIFFER_AMOUNT：null
     */
    public BigDecimal getOUR_REFUND_DIFFER_AMOUNT() {
        return OUR_REFUND_DIFFER_AMOUNT;
    }

    /**
     * set method 
     *
     * @param OUR_REFUND_DIFFER_AMOUNT  null
     */
    public void setOUR_REFUND_DIFFER_AMOUNT(BigDecimal OUR_REFUND_DIFFER_AMOUNT) {
        this.OUR_REFUND_DIFFER_AMOUNT = OUR_REFUND_DIFFER_AMOUNT;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA.CHANNEL_REFUND_DIFFER_AMOUNT：null
     */
    public BigDecimal getCHANNEL_REFUND_DIFFER_AMOUNT() {
        return CHANNEL_REFUND_DIFFER_AMOUNT;
    }

    /**
     * set method 
     *
     * @param CHANNEL_REFUND_DIFFER_AMOUNT  null
     */
    public void setCHANNEL_REFUND_DIFFER_AMOUNT(BigDecimal CHANNEL_REFUND_DIFFER_AMOUNT) {
        this.CHANNEL_REFUND_DIFFER_AMOUNT = CHANNEL_REFUND_DIFFER_AMOUNT;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA.TRADE_EQUAL_NUM：null
     */
    public Integer getTRADE_EQUAL_NUM() {
        return TRADE_EQUAL_NUM;
    }

    /**
     * set method 
     *
     * @param TRADE_EQUAL_NUM  null
     */
    public void setTRADE_EQUAL_NUM(Integer TRADE_EQUAL_NUM) {
        this.TRADE_EQUAL_NUM = TRADE_EQUAL_NUM;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA.TRADE_NOEQUAL_NUM：null
     */
    public Integer getTRADE_NOEQUAL_NUM() {
        return TRADE_NOEQUAL_NUM;
    }

    /**
     * set method 
     *
     * @param TRADE_NOEQUAL_NUM  null
     */
    public void setTRADE_NOEQUAL_NUM(Integer TRADE_NOEQUAL_NUM) {
        this.TRADE_NOEQUAL_NUM = TRADE_NOEQUAL_NUM;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA.REFUND_EQUAL_NUM：null
     */
    public Integer getREFUND_EQUAL_NUM() {
        return REFUND_EQUAL_NUM;
    }

    /**
     * set method 
     *
     * @param REFUND_EQUAL_NUM  null
     */
    public void setREFUND_EQUAL_NUM(Integer REFUND_EQUAL_NUM) {
        this.REFUND_EQUAL_NUM = REFUND_EQUAL_NUM;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA.REFUND_NOEQUAL_NUM：null
     */
    public Integer getREFUND_NOEQUAL_NUM() {
        return REFUND_NOEQUAL_NUM;
    }

    /**
     * set method 
     *
     * @param REFUND_NOEQUAL_NUM  null
     */
    public void setREFUND_NOEQUAL_NUM(Integer REFUND_NOEQUAL_NUM) {
        this.REFUND_NOEQUAL_NUM = REFUND_NOEQUAL_NUM;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA.OUR_TRADE_DIFFER_NUM：null
     */
    public Integer getOUR_TRADE_DIFFER_NUM() {
        return OUR_TRADE_DIFFER_NUM;
    }

    /**
     * set method 
     *
     * @param OUR_TRADE_DIFFER_NUM  null
     */
    public void setOUR_TRADE_DIFFER_NUM(Integer OUR_TRADE_DIFFER_NUM) {
        this.OUR_TRADE_DIFFER_NUM = OUR_TRADE_DIFFER_NUM;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA.CHANNEL_TRADE_DIFFER_NUM：null
     */
    public Integer getCHANNEL_TRADE_DIFFER_NUM() {
        return CHANNEL_TRADE_DIFFER_NUM;
    }

    /**
     * set method 
     *
     * @param CHANNEL_TRADE_DIFFER_NUM  null
     */
    public void setCHANNEL_TRADE_DIFFER_NUM(Integer CHANNEL_TRADE_DIFFER_NUM) {
        this.CHANNEL_TRADE_DIFFER_NUM = CHANNEL_TRADE_DIFFER_NUM;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA.OUR_REFUND_DIFFER_NUM：null
     */
    public Integer getOUR_REFUND_DIFFER_NUM() {
        return OUR_REFUND_DIFFER_NUM;
    }

    /**
     * set method 
     *
     * @param OUR_REFUND_DIFFER_NUM  null
     */
    public void setOUR_REFUND_DIFFER_NUM(Integer OUR_REFUND_DIFFER_NUM) {
        this.OUR_REFUND_DIFFER_NUM = OUR_REFUND_DIFFER_NUM;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA.CHANNEL_REFUND_DIFFER_NUM：null
     */
    public Integer getCHANNEL_REFUND_DIFFER_NUM() {
        return CHANNEL_REFUND_DIFFER_NUM;
    }

    /**
     * set method 
     *
     * @param CHANNEL_REFUND_DIFFER_NUM  null
     */
    public void setCHANNEL_REFUND_DIFFER_NUM(Integer CHANNEL_REFUND_DIFFER_NUM) {
        this.CHANNEL_REFUND_DIFFER_NUM = CHANNEL_REFUND_DIFFER_NUM;
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA.RESULT_STATUS：null
     */
    public String getRESULT_STATUS() {
        return RESULT_STATUS;
    }

    /**
     * set method 
     *
     * @param RESULT_STATUS  null
     */
    public void setRESULT_STATUS(String RESULT_STATUS) {
        this.RESULT_STATUS = RESULT_STATUS == null ? null : RESULT_STATUS.trim();
    }

    /**
     * get method 
     *
     * @return IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA.CREATED_TIME：null
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
     * @return IPAY_CORE_TEST.T_CHECK_ACC_INFO_STA.UPDATED_TIME：null
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
        T_check_acc_info_sta other = (T_check_acc_info_sta) that;
        return (this.getID() == null ? other.getID() == null : this.getID().equals(other.getID()))
            && (this.getCHECK_DATE() == null ? other.getCHECK_DATE() == null : this.getCHECK_DATE().equals(other.getCHECK_DATE()))
            && (this.getCHANNEL_ID() == null ? other.getCHANNEL_ID() == null : this.getCHANNEL_ID().equals(other.getCHANNEL_ID()))
            && (this.getCHANNEL_CODE() == null ? other.getCHANNEL_CODE() == null : this.getCHANNEL_CODE().equals(other.getCHANNEL_CODE()))
            && (this.getOUR_TRADE_AMOUNT() == null ? other.getOUR_TRADE_AMOUNT() == null : this.getOUR_TRADE_AMOUNT().equals(other.getOUR_TRADE_AMOUNT()))
            && (this.getOUR_REFUND_AMOUNT() == null ? other.getOUR_REFUND_AMOUNT() == null : this.getOUR_REFUND_AMOUNT().equals(other.getOUR_REFUND_AMOUNT()))
            && (this.getOUR_DISCOUNT_AMOUNT() == null ? other.getOUR_DISCOUNT_AMOUNT() == null : this.getOUR_DISCOUNT_AMOUNT().equals(other.getOUR_DISCOUNT_AMOUNT()))
            && (this.getOUR_TRADE_NUM() == null ? other.getOUR_TRADE_NUM() == null : this.getOUR_TRADE_NUM().equals(other.getOUR_TRADE_NUM()))
            && (this.getOUR_REFUND_NUM() == null ? other.getOUR_REFUND_NUM() == null : this.getOUR_REFUND_NUM().equals(other.getOUR_REFUND_NUM()))
            && (this.getCHANNEL_TRADE_AMOUNT() == null ? other.getCHANNEL_TRADE_AMOUNT() == null : this.getCHANNEL_TRADE_AMOUNT().equals(other.getCHANNEL_TRADE_AMOUNT()))
            && (this.getCHANNEL_REFUND_AMOUNT() == null ? other.getCHANNEL_REFUND_AMOUNT() == null : this.getCHANNEL_REFUND_AMOUNT().equals(other.getCHANNEL_REFUND_AMOUNT()))
            && (this.getCHANNEL_DISCOUNT_AMOUNT() == null ? other.getCHANNEL_DISCOUNT_AMOUNT() == null : this.getCHANNEL_DISCOUNT_AMOUNT().equals(other.getCHANNEL_DISCOUNT_AMOUNT()))
            && (this.getCHANNEL_TRADE_FEE() == null ? other.getCHANNEL_TRADE_FEE() == null : this.getCHANNEL_TRADE_FEE().equals(other.getCHANNEL_TRADE_FEE()))
            && (this.getCHANNEL_REFUND_FEE() == null ? other.getCHANNEL_REFUND_FEE() == null : this.getCHANNEL_REFUND_FEE().equals(other.getCHANNEL_REFUND_FEE()))
            && (this.getCHANNEL_TRADE_NUM() == null ? other.getCHANNEL_TRADE_NUM() == null : this.getCHANNEL_TRADE_NUM().equals(other.getCHANNEL_TRADE_NUM()))
            && (this.getCHANNEL_REFUND_NUM() == null ? other.getCHANNEL_REFUND_NUM() == null : this.getCHANNEL_REFUND_NUM().equals(other.getCHANNEL_REFUND_NUM()))
            && (this.getTRADE_EQUAL_AMOUNT() == null ? other.getTRADE_EQUAL_AMOUNT() == null : this.getTRADE_EQUAL_AMOUNT().equals(other.getTRADE_EQUAL_AMOUNT()))
            && (this.getREFUND_EQUAL_AMOUNT() == null ? other.getREFUND_EQUAL_AMOUNT() == null : this.getREFUND_EQUAL_AMOUNT().equals(other.getREFUND_EQUAL_AMOUNT()))
            && (this.getTRADE_NOEQUAL_AMOUNT() == null ? other.getTRADE_NOEQUAL_AMOUNT() == null : this.getTRADE_NOEQUAL_AMOUNT().equals(other.getTRADE_NOEQUAL_AMOUNT()))
            && (this.getREFUND_NOEQUAL_AMOUNT() == null ? other.getREFUND_NOEQUAL_AMOUNT() == null : this.getREFUND_NOEQUAL_AMOUNT().equals(other.getREFUND_NOEQUAL_AMOUNT()))
            && (this.getOUR_TRADE_DIFFER_AMOUNT() == null ? other.getOUR_TRADE_DIFFER_AMOUNT() == null : this.getOUR_TRADE_DIFFER_AMOUNT().equals(other.getOUR_TRADE_DIFFER_AMOUNT()))
            && (this.getCHANNEL_TRADE_DIFFER_AMOUNT() == null ? other.getCHANNEL_TRADE_DIFFER_AMOUNT() == null : this.getCHANNEL_TRADE_DIFFER_AMOUNT().equals(other.getCHANNEL_TRADE_DIFFER_AMOUNT()))
            && (this.getOUR_REFUND_DIFFER_AMOUNT() == null ? other.getOUR_REFUND_DIFFER_AMOUNT() == null : this.getOUR_REFUND_DIFFER_AMOUNT().equals(other.getOUR_REFUND_DIFFER_AMOUNT()))
            && (this.getCHANNEL_REFUND_DIFFER_AMOUNT() == null ? other.getCHANNEL_REFUND_DIFFER_AMOUNT() == null : this.getCHANNEL_REFUND_DIFFER_AMOUNT().equals(other.getCHANNEL_REFUND_DIFFER_AMOUNT()))
            && (this.getTRADE_EQUAL_NUM() == null ? other.getTRADE_EQUAL_NUM() == null : this.getTRADE_EQUAL_NUM().equals(other.getTRADE_EQUAL_NUM()))
            && (this.getTRADE_NOEQUAL_NUM() == null ? other.getTRADE_NOEQUAL_NUM() == null : this.getTRADE_NOEQUAL_NUM().equals(other.getTRADE_NOEQUAL_NUM()))
            && (this.getREFUND_EQUAL_NUM() == null ? other.getREFUND_EQUAL_NUM() == null : this.getREFUND_EQUAL_NUM().equals(other.getREFUND_EQUAL_NUM()))
            && (this.getREFUND_NOEQUAL_NUM() == null ? other.getREFUND_NOEQUAL_NUM() == null : this.getREFUND_NOEQUAL_NUM().equals(other.getREFUND_NOEQUAL_NUM()))
            && (this.getOUR_TRADE_DIFFER_NUM() == null ? other.getOUR_TRADE_DIFFER_NUM() == null : this.getOUR_TRADE_DIFFER_NUM().equals(other.getOUR_TRADE_DIFFER_NUM()))
            && (this.getCHANNEL_TRADE_DIFFER_NUM() == null ? other.getCHANNEL_TRADE_DIFFER_NUM() == null : this.getCHANNEL_TRADE_DIFFER_NUM().equals(other.getCHANNEL_TRADE_DIFFER_NUM()))
            && (this.getOUR_REFUND_DIFFER_NUM() == null ? other.getOUR_REFUND_DIFFER_NUM() == null : this.getOUR_REFUND_DIFFER_NUM().equals(other.getOUR_REFUND_DIFFER_NUM()))
            && (this.getCHANNEL_REFUND_DIFFER_NUM() == null ? other.getCHANNEL_REFUND_DIFFER_NUM() == null : this.getCHANNEL_REFUND_DIFFER_NUM().equals(other.getCHANNEL_REFUND_DIFFER_NUM()))
            && (this.getRESULT_STATUS() == null ? other.getRESULT_STATUS() == null : this.getRESULT_STATUS().equals(other.getRESULT_STATUS()))
            && (this.getCREATED_TIME() == null ? other.getCREATED_TIME() == null : this.getCREATED_TIME().equals(other.getCREATED_TIME()))
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
        result = prime * result + ((getCHECK_DATE() == null) ? 0 : getCHECK_DATE().hashCode());
        result = prime * result + ((getCHANNEL_ID() == null) ? 0 : getCHANNEL_ID().hashCode());
        result = prime * result + ((getCHANNEL_CODE() == null) ? 0 : getCHANNEL_CODE().hashCode());
        result = prime * result + ((getOUR_TRADE_AMOUNT() == null) ? 0 : getOUR_TRADE_AMOUNT().hashCode());
        result = prime * result + ((getOUR_REFUND_AMOUNT() == null) ? 0 : getOUR_REFUND_AMOUNT().hashCode());
        result = prime * result + ((getOUR_DISCOUNT_AMOUNT() == null) ? 0 : getOUR_DISCOUNT_AMOUNT().hashCode());
        result = prime * result + ((getOUR_TRADE_NUM() == null) ? 0 : getOUR_TRADE_NUM().hashCode());
        result = prime * result + ((getOUR_REFUND_NUM() == null) ? 0 : getOUR_REFUND_NUM().hashCode());
        result = prime * result + ((getCHANNEL_TRADE_AMOUNT() == null) ? 0 : getCHANNEL_TRADE_AMOUNT().hashCode());
        result = prime * result + ((getCHANNEL_REFUND_AMOUNT() == null) ? 0 : getCHANNEL_REFUND_AMOUNT().hashCode());
        result = prime * result + ((getCHANNEL_DISCOUNT_AMOUNT() == null) ? 0 : getCHANNEL_DISCOUNT_AMOUNT().hashCode());
        result = prime * result + ((getCHANNEL_TRADE_FEE() == null) ? 0 : getCHANNEL_TRADE_FEE().hashCode());
        result = prime * result + ((getCHANNEL_REFUND_FEE() == null) ? 0 : getCHANNEL_REFUND_FEE().hashCode());
        result = prime * result + ((getCHANNEL_TRADE_NUM() == null) ? 0 : getCHANNEL_TRADE_NUM().hashCode());
        result = prime * result + ((getCHANNEL_REFUND_NUM() == null) ? 0 : getCHANNEL_REFUND_NUM().hashCode());
        result = prime * result + ((getTRADE_EQUAL_AMOUNT() == null) ? 0 : getTRADE_EQUAL_AMOUNT().hashCode());
        result = prime * result + ((getREFUND_EQUAL_AMOUNT() == null) ? 0 : getREFUND_EQUAL_AMOUNT().hashCode());
        result = prime * result + ((getTRADE_NOEQUAL_AMOUNT() == null) ? 0 : getTRADE_NOEQUAL_AMOUNT().hashCode());
        result = prime * result + ((getREFUND_NOEQUAL_AMOUNT() == null) ? 0 : getREFUND_NOEQUAL_AMOUNT().hashCode());
        result = prime * result + ((getOUR_TRADE_DIFFER_AMOUNT() == null) ? 0 : getOUR_TRADE_DIFFER_AMOUNT().hashCode());
        result = prime * result + ((getCHANNEL_TRADE_DIFFER_AMOUNT() == null) ? 0 : getCHANNEL_TRADE_DIFFER_AMOUNT().hashCode());
        result = prime * result + ((getOUR_REFUND_DIFFER_AMOUNT() == null) ? 0 : getOUR_REFUND_DIFFER_AMOUNT().hashCode());
        result = prime * result + ((getCHANNEL_REFUND_DIFFER_AMOUNT() == null) ? 0 : getCHANNEL_REFUND_DIFFER_AMOUNT().hashCode());
        result = prime * result + ((getTRADE_EQUAL_NUM() == null) ? 0 : getTRADE_EQUAL_NUM().hashCode());
        result = prime * result + ((getTRADE_NOEQUAL_NUM() == null) ? 0 : getTRADE_NOEQUAL_NUM().hashCode());
        result = prime * result + ((getREFUND_EQUAL_NUM() == null) ? 0 : getREFUND_EQUAL_NUM().hashCode());
        result = prime * result + ((getREFUND_NOEQUAL_NUM() == null) ? 0 : getREFUND_NOEQUAL_NUM().hashCode());
        result = prime * result + ((getOUR_TRADE_DIFFER_NUM() == null) ? 0 : getOUR_TRADE_DIFFER_NUM().hashCode());
        result = prime * result + ((getCHANNEL_TRADE_DIFFER_NUM() == null) ? 0 : getCHANNEL_TRADE_DIFFER_NUM().hashCode());
        result = prime * result + ((getOUR_REFUND_DIFFER_NUM() == null) ? 0 : getOUR_REFUND_DIFFER_NUM().hashCode());
        result = prime * result + ((getCHANNEL_REFUND_DIFFER_NUM() == null) ? 0 : getCHANNEL_REFUND_DIFFER_NUM().hashCode());
        result = prime * result + ((getRESULT_STATUS() == null) ? 0 : getRESULT_STATUS().hashCode());
        result = prime * result + ((getCREATED_TIME() == null) ? 0 : getCREATED_TIME().hashCode());
        result = prime * result + ((getUPDATED_TIME() == null) ? 0 : getUPDATED_TIME().hashCode());
        return result;
    }
}