package com.android.benben.retrofitrxjava.http.bean;
import java.io.Serializable;
import java.util.List;

/**
 * Time      2017/4/10 13:34 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public class ABean implements Serializable {
    /**
     * title : 功夫
     * tag : 喜剧 / 动作 / 犯罪
     * act : 周星驰 元秋 元华 黄圣依 梁小龙 田启文 林子聪 林雪 冯克安 袁祥仁 冯小刚 洪金宝 赵志凌 董志华 张一白 陈国坤
     * year : 2004
     * rating : 7.8
     * area : 香港 / 大陆
     * dir : 周星驰
     * desc : 1940年代的上海，自小受尽欺辱的街头混混阿星（周星驰）为了能出人头地，可谓窥见机会的缝隙就往里钻，今次他盯上行动日益猖獗的黑道势力“斧头帮”，想借之大名成就大业。
     阿星假冒“斧头帮”成员试图在一个叫“猪笼城寨”的地方对居民敲诈，不想引来真的“斧头帮”与“猪笼城寨”居民的恩怨。“猪笼城寨”原是藏龙卧虎之处，居民中有许多身怀绝技者（元华、梁小龙等），他们隐藏于此本是为远离江湖恩怨，不想麻烦自动上身，躲都躲不及。而在观战正邪两派的斗争中，阿星逐渐领悟功夫的真谛。
     * cover : http://p4.qhimg.com/t01f7e2e53c91049609.jpg
     * vdo_status : play
     * playlinks : {"levp":"http://www.le.com/ptv/vplay/1505678.html?ch=360_mfdy","huashu":"http://www.wasu.cn/Play/show/id/5346824?refer=sll","fengxing":"http://www.fun.tv/vplay/m-202316.e-1?alliance=152055","qq":"http://v.qq.com/x/cover/uiq0rxuywu508qr.html?ptag=360kan.movie.free","sohu":null,"youku":null}
     * video_rec : [{"cover":"http://p1.qhimg.com/d/dy_8729606eee70ec4a9ffd323602d372fa.jpg","detail_url":"http://www.360kan.com/m/fqrlYxH3R0H5Sx.html","title":"美人鱼-粤"},{"cover":"http://p5.qhimg.com/d/_hao360/video/n200906_11_144824644.jpg","detail_url":"http://www.360kan.com/m/faPkY0P5RHf5UR.html","title":"食神"},{"cover":"http://p7.qhimg.com/d/dy_f459cec1f0f30a5f49f2b93a6c4d42ff.jpg","detail_url":"http://www.360kan.com/m/fqjkakImQHH8TR.html","title":"龙的传人"}]
     * act_s : [{"name":"周星驰","url":"http://baike.so.com/doc/88963-93978.html","image":"http://p1.qhmsg.com/dmsmty/120_110_100/t01d814acfac335b362.jpg"},{"name":"元秋","url":"http://baike.so.com/doc/4663302-4876791.html","image":"http://p7.qhmsg.com/dmsmty/120_110_100/t01fdde749080734a0f.jpg"},{"name":"元华","url":"http://baike.so.com/doc/4660881-4874303.html","image":"http://p7.qhmsg.com/dmsmty/120_110_100/t010ad2a3639fc92488.jpg"},{"name":"黄圣依","url":"http://baike.so.com/doc/1210312-1280343.html","image":"http://p0.qhmsg.com/dmsmty/120_110_100/t010e0825014475238a.png"},{"name":"梁小龙","url":"http://baike.so.com/doc/3052514-3217778.html","image":"http://p5.qhmsg.com/dmsmty/120_110_100/t016b6dbcc85abfc9dd.jpg"},{"name":"田启文","url":"http://baike.so.com/doc/4651993-4865208.html","image":"http://p7.qhmsg.com/dmsmty/120_110_100/t011e670a9fbb200d9c.jpg"},{"name":"林子聪","url":"http://baike.so.com/doc/4656071-4869382.html","image":"http://p8.qhmsg.com/dmsmty/120_110_100/t0184339eab236c1fd8.jpg"}]
     */

    private String title;
    private String tag;
    private String act;
    private String year;
    private double rating;
    private String area;
    private String dir;
    private String desc;
    private String cover;
    private String vdo_status;
    private PlaylinksBean playlinks;
    private List<VideoRecBean> video_rec;
    private List<ActSBean> act_s;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getVdo_status() {
        return vdo_status;
    }

    public void setVdo_status(String vdo_status) {
        this.vdo_status = vdo_status;
    }

    public PlaylinksBean getPlaylinks() {
        return playlinks;
    }

    public void setPlaylinks(PlaylinksBean playlinks) {
        this.playlinks = playlinks;
    }

    public List<VideoRecBean> getVideo_rec() {
        return video_rec;
    }

    public void setVideo_rec(List<VideoRecBean> video_rec) {
        this.video_rec = video_rec;
    }

    public List<ActSBean> getAct_s() {
        return act_s;
    }

    public void setAct_s(List<ActSBean> act_s) {
        this.act_s = act_s;
    }

    public static class PlaylinksBean implements Serializable {
        /**
         * levp : http://www.le.com/ptv/vplay/1505678.html?ch=360_mfdy
         * huashu : http://www.wasu.cn/Play/show/id/5346824?refer=sll
         * fengxing : http://www.fun.tv/vplay/m-202316.e-1?alliance=152055
         * qq : http://v.qq.com/x/cover/uiq0rxuywu508qr.html?ptag=360kan.movie.free
         * sohu : null
         * youku : null
         */

        private String levp;
        private String huashu;
        private String fengxing;
        private String qq;
        private Object sohu;
        private Object youku;

        public String getLevp() {
            return levp;
        }

        public void setLevp(String levp) {
            this.levp = levp;
        }

        public String getHuashu() {
            return huashu;
        }

        public void setHuashu(String huashu) {
            this.huashu = huashu;
        }

        public String getFengxing() {
            return fengxing;
        }

        public void setFengxing(String fengxing) {
            this.fengxing = fengxing;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public Object getSohu() {
            return sohu;
        }

        public void setSohu(Object sohu) {
            this.sohu = sohu;
        }

        public Object getYouku() {
            return youku;
        }

        public void setYouku(Object youku) {
            this.youku = youku;
        }
    }

    public static class VideoRecBean  implements Serializable{
        /**
         * cover : http://p1.qhimg.com/d/dy_8729606eee70ec4a9ffd323602d372fa.jpg
         * detail_url : http://www.360kan.com/m/fqrlYxH3R0H5Sx.html
         * title : 美人鱼-粤
         */

        private String cover;
        private String detail_url;
        private String title;

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getDetail_url() {
            return detail_url;
        }

        public void setDetail_url(String detail_url) {
            this.detail_url = detail_url;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static class ActSBean implements Serializable {
        /**
         * name : 周星驰
         * url : http://baike.so.com/doc/88963-93978.html
         * image : http://p1.qhmsg.com/dmsmty/120_110_100/t01d814acfac335b362.jpg
         */

        private String name;
        private String url;
        private String image;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
