package jp.co.tis.tiscon4.form;

import jp.co.tis.tiscon4.common.code.JobType;
import nablarch.core.util.StringUtil;
import nablarch.core.validation.ee.Domain;
import nablarch.core.validation.ee.Required;

import javax.validation.constraints.AssertTrue;
import java.io.Serializable;

public class JobForm implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 職業 */
    @Required
    @Domain("job")
    private String job;

    /** その他の職業 */
    @Domain("otherJob")
    private String otherJob;


    /** 勤務先 */
    @Domain("employerName")
    private String employerName;

    /** 勤務先郵便番号 */
    @Domain("employerZipCode")
    private String employerZipCode;

    /** 勤務先住所 */
    @Domain("employerAddress")
    private String employerAddress;

    /** 勤務先電話番号 */
    @Domain("employerPhoneNumber")
    private String employerPhoneNumber;

    /** 業種 */
    @Domain("industryType")
    private String industryType;

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public String getEmployerZipCode() {
        return employerZipCode;
    }

    public void setEmployerZipCode(String employerZipCode) {
        this.employerZipCode = employerZipCode;
    }

    public String getEmployerAddress() {
        return employerAddress;
    }

    public void setEmployerAddress(String employerAddress) {
        this.employerAddress = employerAddress;
    }

    public String getEmployerPhoneNumber() {
        return employerPhoneNumber;
    }

    public void setEmployerPhoneNumber(String employerPhoneNumber) {
        this.employerPhoneNumber = employerPhoneNumber;
    }

    public String getIndustryType() {
        return industryType;
    }

    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getOtherJob() {
        return otherJob;
    }

    public void setOtherJob(String otherJob) {
        this.otherJob = otherJob;
    }

/**
 * その他の職業欄が正しく入力されているかどうか判定する。
 * 職業で「その他（有職）」を選択し、その他の職業欄に何らかの値が入力された場合、正しく入力されたと判定する。
 *
 * @return その他の職業欄に入力がある場合にtrue
 */
    @AssertTrue(message = "{tiscon4.order.inputUser.error.hasValueOtherJob}")
    public boolean hasValueOtherJob() {
        if (StringUtil.isNullOrEmpty(job)) {
            // 職業が未入力の場合は、相関バリデーションは実施しない。(バリデーションOKとする)
            return true;
        } else if (JobType.EMPLOYED.getCode().equals(job) && StringUtil.isNullOrEmpty(otherJob)) {
            return false;
        }
        return true;
    }
}
