package com.puffpdx.api.model.strains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 {
 "name": "13 Roses",
 "ucpc": "9XVU73HWRP000000000000000",
 "link": "https://www.cannabisreports.com/api/v1.0/strains/9XVU73HWRP000000000000000",
 "qr": "https://www.cannabisreports.com/strain-reports/unknown-breeder/13-roses/qr-code.svg",
 "url": "https://www.cannabisreports.com/strain-reports/unknown-breeder/13-roses",
 "image": "https://www.cannabisreports.com/images/strains/no_image.png",
 "seedCompany": {
 "name": "Unknown Breeder",
 "ucpc": "9XVU700000000000000000000",
 "link": "https://www.cannabisreports.com/api/v1.0/seed-companies/9XVU700000000000000000000"
 },
 "genetics": {
 "names": "( X13 x Thai Landrace ) x Rosetta Stone",
 "ucpc": "( 9XVU736RNE000000000000000 x 9XVU7NWEGH000000000000000 ) x 9XVU7DX36T000000000000000",
 "link": "https://www.cannabisreports.com/api/v1.0/strains/9XVU73HWRP000000000000000/genetics"
 },
 "lineage": {
 "Afghanistan": "AF",
 "Colombia": "CO",
 "India": "IN",
 "Mexico": "MX",
 "Thailand": "TH"
 },
 "children": {
 "count": 6,
 "link": "https://www.cannabisreports.com/api/v1.0/strains/9XVU73HWRP000000000000000/children"
 },
 "reviews": {
 "count": 0,
 "link": "https://www.cannabisreports.com/api/v1.0/strains/9XVU73HWRP000000000000000/reviews"
 },
 "createdAt": {
 "datetime": "2016-02-26 22:25:48",
 "timezone": "UTC"
 },
 "updatedAt": {
 "datetime": "2016-02-26 22:25:48",
 "timezone": "UTC"
 }
 }
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StrainData {

    private String name;
    private String ucpc;
    private String link;
    private String qr;
    private String image;
    private SeedCompany seedCompany;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUcpc() {
        return ucpc;
    }

    public void setUcpc(String ucpc) {
        this.ucpc = ucpc;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getQr() {
        return qr;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public SeedCompany getSeedCompany() {
        return seedCompany;
    }

    public void setSeedCompany(SeedCompany seedCompany) {
        this.seedCompany = seedCompany;
    }
}
