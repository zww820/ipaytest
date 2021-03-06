package org.ipay.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class T_merchant_rate implements Serializable {
    /**
     * 表 : T_MERCHANT_RATE
     * 对应字段 : ID
     */
    private Long ID;

    /**
     * 表 : T_MERCHANT_RATE
     * 对应字段 : CHANNEL_ID
     */
    private String CHANNEL_ID;

    /**
     * 表 : T_MERCHANT_RATE
     * 对应字段 : TEMPLATE_ID
     */
    private BigDecimal TEMPLATE_ID;

    /**
     * 表 : T_MERCHANT_RATE
     * 对应字段 : RATE
     */
    private BigDecimal RATE;

    /**
     * 表 : T_MERCHANT_RATE
     * 对应字段 : STATUS
     */
    private String STATUS;

    /**
     * 表 : T_MERCHANT_RATE
     * 对应字段 : APPROVAL_STATUS
     */
    private String APPROVAL_STATUS;

    /**
     * 表 : T_MERCHANT_RATE
     * 对应字段 : APPROVAL_PERSON_ID
     */
    private BigDecimal APPROVAL_PERSON_ID;

    /**
     * 表 : T_MERCHANT_RATE
     * 对应字段 : APPROVAL_TIME
     */
    private Date APPROVAL_TIME;

    /**
     * 表 : T_MERCHANT_RATE
     * 对应字段 : APPROVAL_OPINION
     */
    private String APPROVAL_OPINION;

    /**
     * 表 : T_MERCHANT_RATE
     * 对应字段 : CREATED_ID
     */
    private BigDecimal CREATED_ID;

    /**
     * 表 : T_MERCHANT_RATE
     * 对应字段 : CREATED_TIME
     */
    private Date CREATED_TIME;

    /**
     * 表 : T_MERCHANT_RATE
     * 对应字段 : UPDATED_ID
     */
    private BigDecimal UPDATED_ID;

    /**
     * 表 : T_MERCHANT_RATE
     * 对应字段 : UPDATED_TIME
     */
    private Date UPDATED_TIME;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_MERCHANT_RATE
     *
     * @MBG Generated Fri Sep 01 15:32:59 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * get method 
     *
     * @return T_MERCHANT_RATE.ID：null
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
     * @return T_MERCHANT_RATE.CHANNEL_ID：null
     */
    public String getCHANNEL_ID() {
        return CHANNEL_ID;
    }

    /**
     * set method 
     *
     * @param CHANNEL_ID  null
     */
    public void setCHANNEL_ID(String CHANNEL_ID) {
        this.CHANNEL_ID = CHANNEL_ID == null ? null : CHANNEL_ID.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_RATE.TEMPLATE_ID：null
     */
    public BigDecimal getTEMPLATE_ID() {
        return TEMPLATE_ID;
    }

    /**
     * set method 
     *
     * @param TEMPLATE_ID  null
     */
    public void setTEMPLATE_ID(BigDecimal TEMPLATE_ID) {
        this.TEMPLATE_ID = TEMPLATE_ID;
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_RATE.RATE：null
     */
    public BigDecimal getRATE() {
        return RATE;
    }

    /**
     * set method 
     *
     * @param RATE  null
     */
    public void setRATE(BigDecimal RATE) {
        this.RATE = RATE;
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_RATE.STATUS：null
     */
    public String getSTATUS() {
        return STATUS;
    }

    /**
     * set method 
     *
     * @param STATUS  null
     */
    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS == null ? null : STATUS.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_RATE.APPROVAL_STATUS：null
     */
    public String getAPPROVAL_STATUS() {
        return APPROVAL_STATUS;
    }

    /**
     * set method 
     *
     * @param APPROVAL_STATUS  null
     */
    public void setAPPROVAL_STATUS(String APPROVAL_STATUS) {
        this.APPROVAL_STATUS = APPROVAL_STATUS == null ? null : APPROVAL_STATUS.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_RATE.APPROVAL_PERSON_ID：null
     */
    public BigDecimal getAPPROVAL_PERSON_ID() {
        return APPROVAL_PERSON_ID;
    }

    /**
     * set method 
     *
     * @param APPROVAL_PERSON_ID  null
     */
    public void setAPPROVAL_PERSON_ID(BigDecimal APPROVAL_PERSON_ID) {
        this.APPROVAL_PERSON_ID = APPROVAL_PERSON_ID;
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_RATE.APPROVAL_TIME：null
     */
    public Date getAPPROVAL_TIME() {
        return APPROVAL_TIME;
    }

    /**
     * set method 
     *
     * @param APPROVAL_TIME  null
     */
    public void setAPPROVAL_TIME(Date APPROVAL_TIME) {
        this.APPROVAL_TIME = APPROVAL_TIME;
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_RATE.APPROVAL_OPINION：null
     */
    public String getAPPROVAL_OPINION() {
        return APPROVAL_OPINION;
    }

    /**
     * set method 
     *
     * @param APPROVAL_OPINION  null
     */
    public void setAPPROVAL_OPINION(String APPROVAL_OPINION) {
        this.APPROVAL_OPINION = APPROVAL_OPINION == null ? null : APPROVAL_OPINION.trim();
    }

    /**
     * get method 
     *
     * @return T_MERCHANT_RATE.CREATED_ID：null
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
     * @return T_MERCHANT_RATE.CREATED_TIME：null
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
     * @return T_MERCHANT_RATE.UPDATED_ID：null
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
     * @return T_MERCHANT_RATE.UPDATED_TIME：null
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
        T_merchant_rate other = (T_merchant_rate) that;
        return (this.getID() == null ? other.getID() == null : this.getID().equals(other.getID()))
            && (this.getCHANNEL_ID() == null ? other.getCHANNEL_ID() == null : this.getCHANNEL_ID().equals(other.getCHANNEL_ID()))
            && (this.getTEMPLATE_ID() == null ? other.getTEMPLATE_ID() == null : this.getTEMPLATE_ID().equals(other.getTEMPLATE_ID()))
            && (this.getRATE() == null ? other.getRATE() == null : this.getRATE().equals(other.getRATE()))
            && (this.getSTATUS() == null ? other.getSTATUS() == null : this.getSTATUS().equals(other.getSTATUS()))
            && (this.getAPPROVAL_STATUS() == null ? other.getAPPROVAL_STATUS() == null : this.getAPPROVAL_STATUS().equals(other.getAPPROVAL_STATUS()))
            && (this.getAPPROVAL_PERSON_ID() == null ? other.getAPPROVAL_PERSON_ID() == null : this.getAPPROVAL_PERSON_ID().equals(other.getAPPROVAL_PERSON_ID()))
            && (this.getAPPROVAL_TIME() == null ? other.getAPPROVAL_TIME() == null : this.getAPPROVAL_TIME().equals(other.getAPPROVAL_TIME()))
            && (this.getAPPROVAL_OPINION() == null ? other.getAPPROVAL_OPINION() == null : this.getAPPROVAL_OPINION().equals(other.getAPPROVAL_OPINION()))
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
        result = prime * result + ((getCHANNEL_ID() == null) ? 0 : getCHANNEL_ID().hashCode());
        result = prime * result + ((getTEMPLATE_ID() == null) ? 0 : getTEMPLATE_ID().hashCode());
        result = prime * result + ((getRATE() == null) ? 0 : getRATE().hashCode());
        result = prime * result + ((getSTATUS() == null) ? 0 : getSTATUS().hashCode());
        result = prime * result + ((getAPPROVAL_STATUS() == null) ? 0 : getAPPROVAL_STATUS().hashCode());
        result = prime * result + ((getAPPROVAL_PERSON_ID() == null) ? 0 : getAPPROVAL_PERSON_ID().hashCode());
        result = prime * result + ((getAPPROVAL_TIME() == null) ? 0 : getAPPROVAL_TIME().hashCode());
        result = prime * result + ((getAPPROVAL_OPINION() == null) ? 0 : getAPPROVAL_OPINION().hashCode());
        result = prime * result + ((getCREATED_ID() == null) ? 0 : getCREATED_ID().hashCode());
        result = prime * result + ((getCREATED_TIME() == null) ? 0 : getCREATED_TIME().hashCode());
        result = prime * result + ((getUPDATED_ID() == null) ? 0 : getUPDATED_ID().hashCode());
        result = prime * result + ((getUPDATED_TIME() == null) ? 0 : getUPDATED_TIME().hashCode());
        return result;
    }
}