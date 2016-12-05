package com.puffpdx.api.model.strains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
     "seedCompany": {
         "name": "Unknown Breeder",
         "ucpc": "9XVU700000000000000000000",
         "link": "https://www.cannabisreports.com/api/v1.0/seed-companies/9XVU700000000000000000000"
     }
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SeedCompany {

    private String name;
    private String ucpc;
    private String link;

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

    @Override public String toString() {
        return "SeedCompany{" +
            "name='" + name + '\'' +
            ", ucpc='" + ucpc + '\'' +
            ", link='" + link + '\'' +
            '}';
    }
}
