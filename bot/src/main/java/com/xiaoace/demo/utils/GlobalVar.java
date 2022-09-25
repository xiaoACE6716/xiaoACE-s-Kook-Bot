package com.xiaoace.demo.utils;

public class GlobalVar {

    //help卡片信息
    public static String Card = "[{\n" +
            "    \"type\": \"card\",\n" +
            "    \"theme\": \"secondary\",\n" +
            "    \"size\": \"lg\",\n" +
            "    \"modules\": [{\n" +
            "            \"type\": \"section\",\n" +
            "            \"text\": {\n" +
            "                \"type\": \"kmarkdown\",\n" +
            "                \"content\": \"**指令大全**\"\n" +
            "            }\n" +
            "        },\n" +
            "        {\n" +
            "            \"type\": \"divider\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"type\": \"section\",\n" +
            "            \"text\": {\n" +
            "                \"type\": \"kmarkdown\",\n" +
            "                \"content\": \"`/help`:显示所有可用的指令\"\n" +
            "            }\n" +
            "        },\n" +
            "        {\n" +
            "            \"type\": \"section\",\n" +
            "            \"text\": {\n" +
            "                \"type\": \"kmarkdown\",\n" +
            "                \"content\": \"`/随机二次元`:随机发送一张二次元图片\"\n" +
            "            }\n" +
            "        },\n" +
            "        {\n" +
            "            \"type\": \"section\",\n" +
            "            \"text\": {\n" +
            "                \"type\": \"kmarkdown\",\n" +
            "                \"content\": \"未完待续\"\n" +
            "            }\n" +
            "        },\n" +
            "        {\n" +
            "            \"type\": \"section\",\n" +
            "            \"text\": {\n" +
            "                \"type\": \"kmarkdown\",\n" +
            "                \"content\": \"---\"\n" +
            "            }\n" +
            "        },\n" +
            "        {\n" +
            "            \"type\": \"section\",\n" +
            "            \"text\": {\n" +
            "                \"type\": \"kmarkdown\",\n" +
            "                \"content\": \"KOOK是最好的~~语音~~软件:smile:\"\n" +
            "            }\n" +
            "        },\n" +
            "        {\n" +
            "            \"type\": \"section\",\n" +
            "            \"text\": {\n" +
            "                \"type\": \"kmarkdown\",\n" +
            "                \"content\": \"[xiaoACE的爱发电](https://afdian.net/a/SaltyFishHome)\"\n" +
            "            }\n" +
            "        }\n" +
            "    ]\n" +
            "}]";

    //发图片所用到的卡片信息模板
    public static String picCard = "[\n" +
            "  {\n" +
            "    \"type\": \"card\",\n" +
            "    \"theme\": \"secondary\",\n" +
            "    \"size\": \"lg\",\n" +
            "    \"modules\": [\n" +
            "      {\n" +
            "        \"type\": \"container\",\n" +
            "        \"elements\": [\n" +
            "          {\n" +
            "            \"type\": \"image\",\n" +
            "            \"src\": \"这里是图片链接地址\"\n" +
            "          }\n" +
            "        ]\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "]";

    //全年龄图库API
    public static String allAgePic = "api.iw233.cn/api.php?sort=iw233&type=json";

}
