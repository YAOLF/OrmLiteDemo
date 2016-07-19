package com.android.picassohttputils;

import java.util.List;

/**
 * Created by Administrator on 2016/7/16.
 */
public class Data {

    /**
     * totalpage : 685
     */

    private TotalpageBean totalpage;
    /**
     * totalpage : {"totalpage":685}
     * cid : 192
     * list : [{"title":"2016玛格南摄影大赛公布获奖名单，中国摄影师入围！","pic_url":"http://img2.fengniao.com/article/12_280x210/740/liFcVFrt1Ok9k.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5337175&isPad=1","comment_page_num":1,"comments_num":"1","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5337175&isPad=1","doc_id":"5337175","web_url":"http://image.fengniao.com/533/5337175.html"},{"title":"瑞士FDDM基金会特别展览将于三影堂艺术中心开幕","pic_url":"http://img2.fengniao.com/article/12_280x210/739/lioZEiDkiytc2.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5337173&isPad=1","comment_page_num":1,"comments_num":"1","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5337173&isPad=1","doc_id":"5337173","web_url":"http://image.fengniao.com/533/5337173.html"},{"title":"惊艳了时光 专访《中国照相馆史》作者仝冰雪","pic_url":"http://img2.fengniao.com/article/12_280x210/570/liaQrd58oMgY.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5336958&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5336958&isPad=1","doc_id":"5336958","web_url":"http://image.fengniao.com/533/5336958.html"},{"title":"第二届\u201c集美·阿尔勒国际摄影季\u201d首次发布会","pic_url":"http://img2.fengniao.com/article/12_280x210/528/libSU1Ya4JiPM.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5336916&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5336916&isPad=1","doc_id":"5336916","web_url":"http://image.fengniao.com/533/5336916.html"},{"title":"中国当代影像与北宋时期审美思潮回望","pic_url":"http://img2.fengniao.com/article/12_280x210/530/liRw1o3He5Wc.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5336921&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5336921&isPad=1","doc_id":"5336921","web_url":"http://image.fengniao.com/533/5336921.html"},{"title":"巨型破裂镜头雕塑 纪念于独立战争中殉职的摄影师","pic_url":"http://img2.fengniao.com/article/12_280x210/449/liyeKhUbmLJA.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5335757&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5335757&isPad=1","doc_id":"5335757","web_url":"http://image.fengniao.com/533/5335757.html"}]
     */

    private int cid;
    /**
     * title : 2016玛格南摄影大赛公布获奖名单，中国摄影师入围！
     * pic_url : http://img2.fengniao.com/article/12_280x210/740/liFcVFrt1Ok9k.jpg
     * doc_url : http://api.fengniao.com/app_ipad/news_doc.php?docid=5337175&isPad=1
     * comment_page_num : 1
     * comments_num : 1
     * more_comment_url : http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5337175&isPad=1
     * doc_id : 5337175
     * web_url : http://image.fengniao.com/533/5337175.html
     */

    private List<ListBean> list;

    public TotalpageBean getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(TotalpageBean totalpage) {
        this.totalpage = totalpage;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class TotalpageBean {
        private int totalpage;

        public int getTotalpage() {
            return totalpage;
        }

        public void setTotalpage(int totalpage) {
            this.totalpage = totalpage;
        }
    }

    public static class ListBean {
        private String title;
        private String pic_url;
        private String doc_url;
        private int comment_page_num;
        private String comments_num;
        private String more_comment_url;
        private String doc_id;
        private String web_url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPic_url() {
            return pic_url;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }

        public String getDoc_url() {
            return doc_url;
        }

        public void setDoc_url(String doc_url) {
            this.doc_url = doc_url;
        }

        public int getComment_page_num() {
            return comment_page_num;
        }

        public void setComment_page_num(int comment_page_num) {
            this.comment_page_num = comment_page_num;
        }

        public String getComments_num() {
            return comments_num;
        }

        public void setComments_num(String comments_num) {
            this.comments_num = comments_num;
        }

        public String getMore_comment_url() {
            return more_comment_url;
        }

        public void setMore_comment_url(String more_comment_url) {
            this.more_comment_url = more_comment_url;
        }

        public String getDoc_id() {
            return doc_id;
        }

        public void setDoc_id(String doc_id) {
            this.doc_id = doc_id;
        }

        public String getWeb_url() {
            return web_url;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }
    }
}
