package com.puffpdx.api.service.external;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.puffpdx.api.model.strains.Strains;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CannabisReportsServiceImpl implements CannabisReportsService {

    @Autowired
    public ObjectMapper objectMapper;

    //TODO Replace this with Wiremock
    private static final String staticResponseBody = "{\n" + "  \"data\": [\n" + "    {\n" + "      \"name\": \"13 Roses\",\n" + "      \"ucpc\": \"9XVU73HWRP000000000000000\",\n"
        + "      \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/9XVU73HWRP000000000000000\",\n" + "      \"qr\": \"https://www.cannabisreports.com/strain-reports/unknown-breeder/13-roses/qr-code.svg\",\n"
        + "      \"url\": \"https://www.cannabisreports.com/strain-reports/unknown-breeder/13-roses\",\n" + "      \"image\": \"https://www.cannabisreports.com/images/strains/no_image.png\",\n" + "      \"seedCompany\": {\n"
        + "        \"name\": \"Unknown Breeder\",\n" + "        \"ucpc\": \"9XVU700000000000000000000\",\n" + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/seed-companies/9XVU700000000000000000000\"\n" + "      },\n" + "      \"genetics\": {\n"
        + "        \"names\": \"( X13 x Thai Landrace ) x Rosetta Stone\",\n" + "        \"ucpc\": \"( 9XVU736RNE000000000000000 x 9XVU7NWEGH000000000000000 ) x 9XVU7DX36T000000000000000\",\n"
        + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/9XVU73HWRP000000000000000/genetics\"\n" + "      },\n" + "      \"lineage\": {\n" + "        \"Afghanistan\": \"AF\",\n" + "        \"Colombia\": \"CO\",\n"
        + "        \"India\": \"IN\",\n" + "        \"Mexico\": \"MX\",\n" + "        \"Thailand\": \"TH\"\n" + "      },\n" + "      \"children\": {\n" + "        \"count\": 6,\n"
        + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/9XVU73HWRP000000000000000/children\"\n" + "      },\n" + "      \"reviews\": {\n" + "        \"count\": 0,\n"
        + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/9XVU73HWRP000000000000000/reviews\"\n" + "      },\n" + "      \"createdAt\": {\n" + "        \"datetime\": \"2016-02-26 22:25:48\",\n" + "        \"timezone\": \"UTC\"\n"
        + "      },\n" + "      \"updatedAt\": {\n" + "        \"datetime\": \"2016-02-26 22:25:48\",\n" + "        \"timezone\": \"UTC\"\n" + "      }\n" + "    },\n" + "    {\n" + "      \"name\": \"2 Pounder\",\n"
        + "      \"ucpc\": \"GF7TVA327U000000000000000\",\n" + "      \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/GF7TVA327U000000000000000\",\n"
        + "      \"qr\": \"https://www.cannabisreports.com/strain-reports/kiwiseeds/2-pounder/qr-code.svg\",\n" + "      \"url\": \"https://www.cannabisreports.com/strain-reports/kiwiseeds/2-pounder\",\n"
        + "      \"image\": \"https://www.cannabisreports.com/images/strains/a/full_a88bf34690d4d1288da2dfe8cb85e2d8734799c5.jpg\",\n" + "      \"seedCompany\": {\n" + "        \"name\": \"Kiwiseeds\",\n" + "        \"ucpc\": \"GF7TV00000000000000000000\",\n"
        + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/seed-companies/GF7TV00000000000000000000\"\n" + "      },\n" + "      \"genetics\": {\n" + "        \"names\": \"New Zealand Landrace\",\n"
        + "        \"ucpc\": \"6M9UYGW7F3000000000000000\",\n" + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/GF7TVA327U000000000000000/genetics\"\n" + "      },\n" + "      \"lineage\": {\n" + "        \"New Zealand\": \"NZ\"\n"
        + "      },\n" + "      \"children\": {\n" + "        \"count\": 0,\n" + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/GF7TVA327U000000000000000/children\"\n" + "      },\n" + "      \"reviews\": {\n" + "        \"count\": 0,\n"
        + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/GF7TVA327U000000000000000/reviews\"\n" + "      },\n" + "      \"createdAt\": {\n" + "        \"datetime\": \"2008-08-15 19:20:00\",\n" + "        \"timezone\": \"UTC\"\n"
        + "      },\n" + "      \"updatedAt\": {\n" + "        \"datetime\": \"2014-06-08 03:20:59\",\n" + "        \"timezone\": \"UTC\"\n" + "      }\n" + "    },\n" + "    {\n" + "      \"name\": \"24 Carat\",\n"
        + "      \"ucpc\": \"7NXXHKUAQD000000000000000\",\n" + "      \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/7NXXHKUAQD000000000000000\",\n"
        + "      \"qr\": \"https://www.cannabisreports.com/strain-reports/mephisto-genetics/24-carat/qr-code.svg\",\n" + "      \"url\": \"https://www.cannabisreports.com/strain-reports/mephisto-genetics/24-carat\",\n"
        + "      \"image\": \"https://www.cannabisreports.com/images/strains/3/full_3485dd39f71898f4f63c75777856ebc272bcbc2a.jpg\",\n" + "      \"seedCompany\": {\n" + "        \"name\": \"Mephisto Genetics\",\n"
        + "        \"ucpc\": \"7NXXH00000000000000000000\",\n" + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/seed-companies/7NXXH00000000000000000000\"\n" + "      },\n" + "      \"genetics\": {\n"
        + "        \"names\": \"Sour Boggle x Purple Indica\",\n" + "        \"ucpc\": \"3F64FW3RTJ000000000000000 x 9XVU7KCCNM000000000000000\",\n" + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/7NXXHKUAQD000000000000000/genetics\"\n"
        + "      },\n" + "      \"lineage\": {\n" + "        \"Afghanistan\": \"AF\",\n" + "        \"Colombia\": \"CO\",\n" + "        \"Mexico\": \"MX\",\n" + "        \"Thailand\": \"TH\"\n" + "      },\n" + "      \"children\": {\n"
        + "        \"count\": 2,\n" + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/7NXXHKUAQD000000000000000/children\"\n" + "      },\n" + "      \"reviews\": {\n" + "        \"count\": 0,\n"
        + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/7NXXHKUAQD000000000000000/reviews\"\n" + "      },\n" + "      \"createdAt\": {\n" + "        \"datetime\": \"2015-01-27 21:25:58\",\n" + "        \"timezone\": \"UTC\"\n"
        + "      },\n" + "      \"updatedAt\": {\n" + "        \"datetime\": \"2015-03-16 23:58:38\",\n" + "        \"timezone\": \"UTC\"\n" + "      }\n" + "    },\n" + "    {\n" + "      \"name\": \"24K Gold\",\n"
        + "      \"ucpc\": \"GM6NY9XWCX000000000000000\",\n" + "      \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/GM6NY9XWCX000000000000000\",\n"
        + "      \"qr\": \"https://www.cannabisreports.com/strain-reports/crockett-family-farms/24k-gold/qr-code.svg\",\n" + "      \"url\": \"https://www.cannabisreports.com/strain-reports/crockett-family-farms/24k-gold\",\n"
        + "      \"image\": \"https://www.cannabisreports.com/images/strains/no_image.png\",\n" + "      \"seedCompany\": {\n" + "        \"name\": \"Crockett Family Farms\",\n" + "        \"ucpc\": \"GM6NY00000000000000000000\",\n"
        + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/seed-companies/GM6NY00000000000000000000\"\n" + "      },\n" + "      \"genetics\": {\n" + "        \"names\": \"Kosher Kush x Tangie\",\n"
        + "        \"ucpc\": \"4PNYLP9L7P000000000000000 x TTUYNYGWNA000000000000000\",\n" + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/GM6NY9XWCX000000000000000/genetics\"\n" + "      },\n" + "      \"lineage\": [],\n"
        + "      \"children\": {\n" + "        \"count\": 0,\n" + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/GM6NY9XWCX000000000000000/children\"\n" + "      },\n" + "      \"reviews\": {\n" + "        \"count\": 0,\n"
        + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/GM6NY9XWCX000000000000000/reviews\"\n" + "      },\n" + "      \"createdAt\": {\n" + "        \"datetime\": \"2015-12-10 03:52:17\",\n" + "        \"timezone\": \"UTC\"\n"
        + "      },\n" + "      \"updatedAt\": {\n" + "        \"datetime\": \"2015-12-10 03:52:18\",\n" + "        \"timezone\": \"UTC\"\n" + "      }\n" + "    },\n" + "    {\n" + "      \"name\": \"26 Cookies\",\n"
        + "      \"ucpc\": \"YFTYM43M7X000000000000000\",\n" + "      \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/YFTYM43M7X000000000000000\",\n"
        + "      \"qr\": \"https://www.cannabisreports.com/strain-reports/riot-seeds/26-cookies/qr-code.svg\",\n" + "      \"url\": \"https://www.cannabisreports.com/strain-reports/riot-seeds/26-cookies\",\n"
        + "      \"image\": \"https://www.cannabisreports.com/images/strains/no_image.png\",\n" + "      \"seedCompany\": {\n" + "        \"name\": \"Riot Seeds\",\n" + "        \"ucpc\": \"YFTYM00000000000000000000\",\n"
        + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/seed-companies/YFTYM00000000000000000000\"\n" + "      },\n" + "      \"genetics\": {\n" + "        \"names\": \"Girl Scout Cookies x West Coast Dawg 710\",\n"
        + "        \"ucpc\": \"4KXM32V9YF000000000000000 x YFTYMJTJVW000000000000000\",\n" + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/YFTYM43M7X000000000000000/genetics\"\n" + "      },\n" + "      \"lineage\": {\n"
        + "        \"Afghanistan\": \"AF\",\n" + "        \"South Africa\": \"ZA\",\n" + "        \"United States\": \"US\"\n" + "      },\n" + "      \"children\": {\n" + "        \"count\": 0,\n"
        + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/YFTYM43M7X000000000000000/children\"\n" + "      },\n" + "      \"reviews\": {\n" + "        \"count\": 0,\n"
        + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/YFTYM43M7X000000000000000/reviews\"\n" + "      },\n" + "      \"createdAt\": {\n" + "        \"datetime\": \"2016-06-13 19:06:52\",\n" + "        \"timezone\": \"UTC\"\n"
        + "      },\n" + "      \"updatedAt\": {\n" + "        \"datetime\": \"2016-06-13 19:06:52\",\n" + "        \"timezone\": \"UTC\"\n" + "      }\n" + "    },\n" + "    {\n" + "      \"name\": \"3 Kings\",\n"
        + "      \"ucpc\": \"9XVU7EGRAZ000000000000000\",\n" + "      \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/9XVU7EGRAZ000000000000000\",\n"
        + "      \"qr\": \"https://www.cannabisreports.com/strain-reports/unknown-breeder/3-kings/qr-code.svg\",\n" + "      \"url\": \"https://www.cannabisreports.com/strain-reports/unknown-breeder/3-kings\",\n"
        + "      \"image\": \"https://www.cannabisreports.com/images/strains/0/full_0ff062001650961817ba4bd41b3243a46ba0b017.jpg\",\n" + "      \"seedCompany\": {\n" + "        \"name\": \"Unknown Breeder\",\n"
        + "        \"ucpc\": \"9XVU700000000000000000000\",\n" + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/seed-companies/9XVU700000000000000000000\"\n" + "      },\n" + "      \"genetics\": {\n"
        + "        \"names\": \"Headband / OG Kush / Sour Diesel\",\n" + "        \"ucpc\": \"9XVU7QRN3Y000000000000000 / 9XVU7GD2AP000000000000000 / 9XVU7KVPFZ000000000000000\",\n"
        + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/9XVU7EGRAZ000000000000000/genetics\"\n" + "      },\n" + "      \"lineage\": {\n" + "        \"Afghanistan\": \"AF\",\n" + "        \"Colombia\": \"CO\",\n"
        + "        \"Mexico\": \"MX\"\n" + "      },\n" + "      \"children\": {\n" + "        \"count\": 3,\n" + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/9XVU7EGRAZ000000000000000/children\"\n" + "      },\n"
        + "      \"reviews\": {\n" + "        \"count\": 3,\n" + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/9XVU7EGRAZ000000000000000/reviews\"\n" + "      },\n" + "      \"createdAt\": {\n"
        + "        \"datetime\": \"2014-06-25 21:05:19\",\n" + "        \"timezone\": \"UTC\"\n" + "      },\n" + "      \"updatedAt\": {\n" + "        \"datetime\": \"2014-06-25 21:05:20\",\n" + "        \"timezone\": \"UTC\"\n" + "      }\n" + "    },\n"
        + "    {\n" + "      \"name\": \"3 Kings x Cheese\",\n" + "      \"ucpc\": \"9XVU7HX776000000000000000\",\n" + "      \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/9XVU7HX776000000000000000\",\n"
        + "      \"qr\": \"https://www.cannabisreports.com/strain-reports/unknown-breeder/3-kings-x-cheese/qr-code.svg\",\n" + "      \"url\": \"https://www.cannabisreports.com/strain-reports/unknown-breeder/3-kings-x-cheese\",\n"
        + "      \"image\": \"https://www.cannabisreports.com/images/strains/no_image.png\",\n" + "      \"seedCompany\": {\n" + "        \"name\": \"Unknown Breeder\",\n" + "        \"ucpc\": \"9XVU700000000000000000000\",\n"
        + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/seed-companies/9XVU700000000000000000000\"\n" + "      },\n" + "      \"genetics\": {\n" + "        \"names\": \"3 Kings x Cheese\",\n"
        + "        \"ucpc\": \"9XVU7EGRAZ000000000000000 x 9XVU7XQALK000000000000000\",\n" + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/9XVU7HX776000000000000000/genetics\"\n" + "      },\n" + "      \"lineage\": {\n"
        + "        \"Afghanistan\": \"AF\",\n" + "        \"Colombia\": \"CO\",\n" + "        \"Mexico\": \"MX\",\n" + "        \"Thailand\": \"TH\"\n" + "      },\n" + "      \"children\": {\n" + "        \"count\": 0,\n"
        + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/9XVU7HX776000000000000000/children\"\n" + "      },\n" + "      \"reviews\": {\n" + "        \"count\": 0,\n"
        + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/9XVU7HX776000000000000000/reviews\"\n" + "      },\n" + "      \"createdAt\": {\n" + "        \"datetime\": \"2015-08-11 00:25:04\",\n" + "        \"timezone\": \"UTC\"\n"
        + "      },\n" + "      \"updatedAt\": {\n" + "        \"datetime\": \"2015-08-11 00:25:05\",\n" + "        \"timezone\": \"UTC\"\n" + "      }\n" + "    },\n" + "    {\n" + "      \"name\": \"303 OG Kush\",\n"
        + "      \"ucpc\": \"9XVU7DPMMW000000000000000\",\n" + "      \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/9XVU7DPMMW000000000000000\",\n"
        + "      \"qr\": \"https://www.cannabisreports.com/strain-reports/unknown-breeder/303-og-kush/qr-code.svg\",\n" + "      \"url\": \"https://www.cannabisreports.com/strain-reports/unknown-breeder/303-og-kush\",\n"
        + "      \"image\": \"https://www.cannabisreports.com/images/strains/no_image.png\",\n" + "      \"seedCompany\": {\n" + "        \"name\": \"Unknown Breeder\",\n" + "        \"ucpc\": \"9XVU700000000000000000000\",\n"
        + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/seed-companies/9XVU700000000000000000000\"\n" + "      },\n" + "      \"genetics\": {\n" + "        \"names\": \"Pre 98 Bubba Kush x Chem Dawg (Chemdog)\",\n"
        + "        \"ucpc\": \"9XVU79UTCY000000000000000 x 9XVU762EQ4000000000000000\",\n" + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/9XVU7DPMMW000000000000000/genetics\"\n" + "      },\n" + "      \"lineage\": [],\n"
        + "      \"children\": {\n" + "        \"count\": 0,\n" + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/9XVU7DPMMW000000000000000/children\"\n" + "      },\n" + "      \"reviews\": {\n" + "        \"count\": 0,\n"
        + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/9XVU7DPMMW000000000000000/reviews\"\n" + "      },\n" + "      \"createdAt\": {\n" + "        \"datetime\": \"2008-08-15 19:20:00\",\n" + "        \"timezone\": \"UTC\"\n"
        + "      },\n" + "      \"updatedAt\": {\n" + "        \"datetime\": \"2016-03-07 18:12:55\",\n" + "        \"timezone\": \"UTC\"\n" + "      }\n" + "    },\n" + "    {\n" + "      \"name\": \"303 Stooges\",\n"
        + "      \"ucpc\": \"G29NGRNNAE000000000000000\",\n" + "      \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/G29NGRNNAE000000000000000\",\n"
        + "      \"qr\": \"https://www.cannabisreports.com/strain-reports/dark-horse-genetics/303-stooges/qr-code.svg\",\n" + "      \"url\": \"https://www.cannabisreports.com/strain-reports/dark-horse-genetics/303-stooges\",\n"
        + "      \"image\": \"https://www.cannabisreports.com/images/strains/no_image.png\",\n" + "      \"seedCompany\": {\n" + "        \"name\": \"Dark Horse Genetics\",\n" + "        \"ucpc\": \"G29NG00000000000000000000\",\n"
        + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/seed-companies/G29NG00000000000000000000\"\n" + "      },\n" + "      \"genetics\": {\n" + "        \"names\": \"( Suge Pure Kush x Snow Lotus ) x ( Strawberry Fields x Haze )\",\n"
        + "        \"ucpc\": \"( 9XVU7XA32W000000000000000 x U9XW7JHLNV000000000000000 ) x ( 9XVU7M43NE000000000000000 x 9XVU7WJQCD000000000000000 )\",\n"
        + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/G29NGRNNAE000000000000000/genetics\"\n" + "      },\n" + "      \"lineage\": {\n" + "        \"Afghanistan\": \"AF\",\n" + "        \"Colombia\": \"CO\",\n"
        + "        \"India\": \"IN\",\n" + "        \"Mexico\": \"MX\",\n" + "        \"Thailand\": \"TH\"\n" + "      },\n" + "      \"children\": {\n" + "        \"count\": 0,\n"
        + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/G29NGRNNAE000000000000000/children\"\n" + "      },\n" + "      \"reviews\": {\n" + "        \"count\": 0,\n"
        + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/G29NGRNNAE000000000000000/reviews\"\n" + "      },\n" + "      \"createdAt\": {\n" + "        \"datetime\": \"2015-11-09 02:31:39\",\n" + "        \"timezone\": \"UTC\"\n"
        + "      },\n" + "      \"updatedAt\": {\n" + "        \"datetime\": \"2015-11-09 02:31:39\",\n" + "        \"timezone\": \"UTC\"\n" + "      }\n" + "    },\n" + "    {\n" + "      \"name\": \"3D\",\n"
        + "      \"ucpc\": \"G3YM7WFQ4U000000000000000\",\n" + "      \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/G3YM7WFQ4U000000000000000\",\n"
        + "      \"qr\": \"https://www.cannabisreports.com/strain-reports/apothecary-seed-company/3d/qr-code.svg\",\n" + "      \"url\": \"https://www.cannabisreports.com/strain-reports/apothecary-seed-company/3d\",\n"
        + "      \"image\": \"https://www.cannabisreports.com/images/strains/no_image.png\",\n" + "      \"seedCompany\": {\n" + "        \"name\": \"Apothecary Seed Company\",\n" + "        \"ucpc\": \"G3YM700000000000000000000\",\n"
        + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/seed-companies/G3YM700000000000000000000\"\n" + "      },\n" + "      \"genetics\": {\n" + "        \"names\": \"Triple X (XXX) x Sour Diesel\",\n"
        + "        \"ucpc\": \"G3YM79PKHU000000000000000 x 9XVU7KVPFZ000000000000000\",\n" + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/G3YM7WFQ4U000000000000000/genetics\"\n" + "      },\n" + "      \"lineage\": [],\n"
        + "      \"children\": {\n" + "        \"count\": 0,\n" + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/G3YM7WFQ4U000000000000000/children\"\n" + "      },\n" + "      \"reviews\": {\n" + "        \"count\": 0,\n"
        + "        \"link\": \"https://www.cannabisreports.com/api/v1.0/strains/G3YM7WFQ4U000000000000000/reviews\"\n" + "      },\n" + "      \"createdAt\": {\n" + "        \"datetime\": \"2008-08-15 19:20:00\",\n" + "        \"timezone\": \"UTC\"\n"
        + "      },\n" + "      \"updatedAt\": {\n" + "        \"datetime\": \"2014-09-23 03:58:59\",\n" + "        \"timezone\": \"UTC\"\n" + "      }\n" + "    }\n" + "  ],\n" + "  \"meta\": {\n" + "    \"pagination\": {\n" + "      \"total\": 9006,\n"
        + "      \"count\": 10,\n" + "      \"per_page\": 10,\n" + "      \"current_page\": 3,\n" + "      \"total_pages\": 901,\n" + "      \"links\": {\n" + "        \"previous\": \"https://www.cannabisreports.com/api/v1.0/strains?sort=name&page=2\",\n"
        + "        \"next\": \"https://www.cannabisreports.com/api/v1.0/strains?sort=name&page=4\"\n" + "      }\n" + "    }\n" + "  }\n" + "}";


    @Override
    public Strains getStrains(String sort, String page) {
        Strains strains = null;

        System.out.println("staticResponseBody = " + staticResponseBody);

        try {
            strains = objectMapper.readValue(staticResponseBody, Strains.class);
        } catch (IOException e) {
            //TODO Handle Parse exception
            e.printStackTrace();
        }

        return strains;
    }
}
