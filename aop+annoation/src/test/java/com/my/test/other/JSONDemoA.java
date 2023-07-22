package com.my.test.other;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class JSONDemoA {


    @Test
    public void testA() {
        List<FruitEntity> entityList = JSONUtil.toList(gerSourceText(), FruitEntity.class);
        if (CollUtil.isEmpty(entityList)) {
            return;
        }
        StringJoiner stringJoiner = new StringJoiner("\n");
        for (FruitEntity fruit : entityList) {
            StringBuilder stringBuilder = new StringBuilder();
            IndexEntity indexEntity = new IndexEntity();
            indexEntity.set_index("shopping");
            indexEntity.set_type("_doc");
            indexEntity.set_id(fruit.getID());
            stringBuilder.append("{\"create\":").append(JSONUtil.toJsonStr(indexEntity)).append("}");
            stringBuilder.append("\n");
            stringBuilder.append("").append(JSONUtil.toJsonStr(fruit)).append("") ;
            stringJoiner.add(stringBuilder.toString()) ;
        }

        System.out.println(stringJoiner.toString());
    }


    private String gerSourceText() {
        String str = "";
        str = "[\n" +
                "        {\n" +
                "            \"AG_PRICE\": 18.5,\n" +
                "            \"CRAFT_NAME\": \"芒果\",\n" +
                "            \"C_UNIT\": \"元/公斤\",\n" +
                "            \"GET_P_DATE\": 1689955200000,\n" +
                "            \"CRAFT_INDEX\": \"13228\",\n" +
                "            \"PAR_INDEX\": 13076,\n" +
                "            \"PROMULGATE_DATE\": 1690011326000,\n" +
                "            \"ID\": 20540,\n" +
                "            \"P_INDEX\": \"110500\",\n" +
                "            \"EUD_PIC\": \"/tc/20210328232229261943.jpg\",\n" +
                "            \"EUD_NAME\": \"北京朝阳区大洋路综合市场\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"AG_PRICE\": 14,\n" +
                "            \"CRAFT_NAME\": \"芒果\",\n" +
                "            \"C_UNIT\": \"元/公斤\",\n" +
                "            \"GET_P_DATE\": 1689955200000,\n" +
                "            \"CRAFT_INDEX\": \"13228\",\n" +
                "            \"PAR_INDEX\": 13076,\n" +
                "            \"PROMULGATE_DATE\": 1690011312000,\n" +
                "            \"ID\": 20531,\n" +
                "            \"P_INDEX\": \"110600\",\n" +
                "            \"EUD_PIC\": \"/tc/20210422093833425915.jpeg\",\n" +
                "            \"EUD_NAME\": \"北京新发地农副产品批发市场信息中心\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"AG_PRICE\": 22,\n" +
                "            \"CRAFT_NAME\": \"芒果(台农一号)\",\n" +
                "            \"C_UNIT\": \"元/公斤\",\n" +
                "            \"GET_P_DATE\": 1689955200000,\n" +
                "            \"CRAFT_INDEX\": \"15052367\",\n" +
                "            \"PAR_INDEX\": 13076,\n" +
                "            \"PROMULGATE_DATE\": 1690011314000,\n" +
                "            \"ID\": 20531,\n" +
                "            \"P_INDEX\": \"110600\",\n" +
                "            \"EUD_PIC\": \"/tc/20210422093833425915.jpeg\",\n" +
                "            \"EUD_NAME\": \"北京新发地农副产品批发市场信息中心\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"AG_PRICE\": 20,\n" +
                "            \"CRAFT_NAME\": \"芒果\",\n" +
                "            \"C_UNIT\": \"元/公斤\",\n" +
                "            \"GET_P_DATE\": 1689955200000,\n" +
                "            \"CRAFT_INDEX\": \"13228\",\n" +
                "            \"PAR_INDEX\": 13076,\n" +
                "            \"PROMULGATE_DATE\": 1690011334000,\n" +
                "            \"ID\": 20536,\n" +
                "            \"P_INDEX\": \"111200\",\n" +
                "            \"EUD_PIC\": \"/tc/20210330163120050216.jpg\",\n" +
                "            \"EUD_NAME\": \"北京八里桥农产品中心批发市场有限公司\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"AG_PRICE\": 8,\n" +
                "            \"CRAFT_NAME\": \"芒果\",\n" +
                "            \"C_UNIT\": \"元/公斤\",\n" +
                "            \"GET_P_DATE\": 1689955200000,\n" +
                "            \"CRAFT_INDEX\": \"13228\",\n" +
                "            \"PAR_INDEX\": 13076,\n" +
                "            \"PROMULGATE_DATE\": 1690011326000,\n" +
                "            \"ID\": 20570,\n" +
                "            \"P_INDEX\": \"121100\",\n" +
                "            \"EUD_PIC\": \"/tc/20200330233852289284.jpg\",\n" +
                "            \"EUD_NAME\": \"天津市红旗农贸综合批发市场有限公司\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"AG_PRICE\": 6.7,\n" +
                "            \"CRAFT_NAME\": \"芒果\",\n" +
                "            \"C_UNIT\": \"元/公斤\",\n" +
                "            \"GET_P_DATE\": 1689955200000,\n" +
                "            \"CRAFT_INDEX\": \"13228\",\n" +
                "            \"PAR_INDEX\": 13076,\n" +
                "            \"PROMULGATE_DATE\": 1690011322000,\n" +
                "            \"ID\": 71830481,\n" +
                "            \"P_INDEX\": \"140107\",\n" +
                "            \"EUD_PIC\": \"/tc/20220412164849161585.jpg\",\n" +
                "            \"EUD_NAME\": \"山西太原丈子头农产品物流园（原城东利民）\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"AG_PRICE\": 6.5,\n" +
                "            \"CRAFT_NAME\": \"芒果\",\n" +
                "            \"C_UNIT\": \"元/公斤\",\n" +
                "            \"GET_P_DATE\": 1689955200000,\n" +
                "            \"CRAFT_INDEX\": \"13228\",\n" +
                "            \"PAR_INDEX\": 13076,\n" +
                "            \"PROMULGATE_DATE\": 1690011323000,\n" +
                "            \"ID\": 2550411,\n" +
                "            \"P_INDEX\": \"140109\",\n" +
                "            \"EUD_PIC\": \"/tc/20201104152043439244.jpg\",\n" +
                "            \"EUD_NAME\": \"山西省太原市河西农产品有限公司\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"AG_PRICE\": 8,\n" +
                "            \"CRAFT_NAME\": \"芒果\",\n" +
                "            \"C_UNIT\": \"元/公斤\",\n" +
                "            \"GET_P_DATE\": 1689955200000,\n" +
                "            \"CRAFT_INDEX\": \"13228\",\n" +
                "            \"PAR_INDEX\": 13076,\n" +
                "            \"PROMULGATE_DATE\": 1690011327000,\n" +
                "            \"ID\": 45065,\n" +
                "            \"P_INDEX\": \"140401\",\n" +
                "            \"EUD_PIC\": \"/tc/20201030190259796033.jpg\",\n" +
                "            \"EUD_NAME\": \"长治市金鑫瓜果批发市场\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"AG_PRICE\": 8.27,\n" +
                "            \"CRAFT_NAME\": \"芒果\",\n" +
                "            \"C_UNIT\": \"元/公斤\",\n" +
                "            \"GET_P_DATE\": 1689955200000,\n" +
                "            \"CRAFT_INDEX\": \"13228\",\n" +
                "            \"PAR_INDEX\": 13076,\n" +
                "            \"PROMULGATE_DATE\": 1690011333000,\n" +
                "            \"ID\": 20969,\n" +
                "            \"P_INDEX\": \"320201\",\n" +
                "            \"EUD_PIC\": \"/tc/20221127110546103791.jpg\",\n" +
                "            \"EUD_NAME\": \"江苏无锡朝阳农产品大市场\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"AG_PRICE\": 12,\n" +
                "            \"CRAFT_NAME\": \"芒果\",\n" +
                "            \"C_UNIT\": \"元/公斤\",\n" +
                "            \"GET_P_DATE\": 1689955200000,\n" +
                "            \"CRAFT_INDEX\": \"13228\",\n" +
                "            \"PAR_INDEX\": 13076,\n" +
                "            \"PROMULGATE_DATE\": 1690011319000,\n" +
                "            \"ID\": 20959,\n" +
                "            \"P_INDEX\": \"320401\",\n" +
                "            \"EUD_PIC\": \"/tc/20200817104333886984.jpg\",\n" +
                "            \"EUD_NAME\": \"江苏凌家塘市场发展有限公司\"\n" +
                "        }\n" +
                "    ]";

        return str;
    }


}


/**
 * Auto-generated: 2023-07-22 18:4:42
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
class FruitEntity {

    private int AG_PRICE;
    private String CRAFT_NAME;
    private String C_UNIT;
    private long GET_P_DATE;
    private String CRAFT_INDEX;
    private int PAR_INDEX;
    private long PROMULGATE_DATE;
    private int ID;
    private String P_INDEX;
    private String EUD_PIC;
    private String EUD_NAME;

    public void setAG_PRICE(int AG_PRICE) {
        this.AG_PRICE = AG_PRICE;
    }

    public int getAG_PRICE() {
        return AG_PRICE;
    }

    public void setCRAFT_NAME(String CRAFT_NAME) {
        this.CRAFT_NAME = CRAFT_NAME;
    }

    public String getCRAFT_NAME() {
        return CRAFT_NAME;
    }

    public void setC_UNIT(String C_UNIT) {
        this.C_UNIT = C_UNIT;
    }

    public String getC_UNIT() {
        return C_UNIT;
    }

    public void setGET_P_DATE(long GET_P_DATE) {
        this.GET_P_DATE = GET_P_DATE;
    }

    public long getGET_P_DATE() {
        return GET_P_DATE;
    }

    public void setCRAFT_INDEX(String CRAFT_INDEX) {
        this.CRAFT_INDEX = CRAFT_INDEX;
    }

    public String getCRAFT_INDEX() {
        return CRAFT_INDEX;
    }

    public void setPAR_INDEX(int PAR_INDEX) {
        this.PAR_INDEX = PAR_INDEX;
    }

    public int getPAR_INDEX() {
        return PAR_INDEX;
    }

    public void setPROMULGATE_DATE(long PROMULGATE_DATE) {
        this.PROMULGATE_DATE = PROMULGATE_DATE;
    }

    public long getPROMULGATE_DATE() {
        return PROMULGATE_DATE;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setP_INDEX(String P_INDEX) {
        this.P_INDEX = P_INDEX;
    }

    public String getP_INDEX() {
        return P_INDEX;
    }

    public void setEUD_PIC(String EUD_PIC) {
        this.EUD_PIC = EUD_PIC;
    }

    public String getEUD_PIC() {
        return EUD_PIC;
    }

    public void setEUD_NAME(String EUD_NAME) {
        this.EUD_NAME = EUD_NAME;
    }

    public String getEUD_NAME() {
        return EUD_NAME;
    }

}


/**
 * Auto-generated: 2023-07-22 18:10:19
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
class IndexEntity {

    private String _index;
    private String _type;
    private int _id;

    public void set_index(String _index) {
        this._index = _index;
    }

    public String get_index() {
        return _index;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public String get_type() {
        return _type;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int get_id() {
        return _id;
    }

}
