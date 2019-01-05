package com.mrKhoai.webshop.objects;

import javax.persistence.*;

@Entity
@Table(name = "CV")
public class CV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CV_ID", nullable = false, unique = true, length = 30)
    private int cvId;

    @Column(name = "CV_NAME", nullable = false)
    private String cvName;

    @Column(name = "CV_EMAIL")
    private String cvEmail;

    @Column(name = "CV_ADDRESS")
    private String cvAddress;

    @Column(name = "CV_CITY")
    private String cvCity;

    @Column(name = "CV_POSTCODE")
    private int cvPostcode;

    @Column(name = "CV_COUNTRY")
    private String cvCountry;

    @OneToOne
    @JoinColumn(name = "STAFF_ID")
    private Staff staff;

    public int getCvId() {
        return cvId;
    }

    public void setCvId(int cvId) {
        this.cvId = cvId;
    }

    public String getCvName() {
        return cvName;
    }

    public void setCvName(String cvName) {
        this.cvName = cvName;
    }

    public String getCvEmail() {
        return cvEmail;
    }

    public void setCvEmail(String cvEmail) {
        this.cvEmail = cvEmail;
    }

    public String getCvAddress() {
        return cvAddress;
    }

    public void setCvAddress(String cvAddress) {
        this.cvAddress = cvAddress;
    }

    public String getCvCity() {
        return cvCity;
    }

    public void setCvCity(String cvCity) {
        this.cvCity = cvCity;
    }

    public int getCvPostcode() {
        return cvPostcode;
    }

    public void setCvPostcode(int cvPostcode) {
        this.cvPostcode = cvPostcode;
    }

    public String getCvCountry() {
        return cvCountry;
    }

    public void setCvCountry(String cvCountry) {
        this.cvCountry = cvCountry;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id : " + cvId + ", " +
                "name : " + cvName + ", " +
                "email : " + cvEmail + ", " +
                "adress : " + cvAddress + ", " +
                "city : " + cvCity + ", " +
                "postcode : " + cvPostcode + ", " +
                "country : " + cvCountry +
                "}";
    }
}
