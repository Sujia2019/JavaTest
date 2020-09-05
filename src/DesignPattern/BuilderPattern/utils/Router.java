package DesignPattern.BuilderPattern.utils;

import static DesignPattern.BuilderPattern.utils.Router.Emoji.HAHA;
import static DesignPattern.BuilderPattern.utils.Router.Emoji.WUWU;
import static DesignPattern.BuilderPattern.utils.Router.Pic.PEOPLE;
import static DesignPattern.BuilderPattern.utils.Router.Pic.VIEW;
import java.util.LinkedList;
import java.util.List;

/**
 * 路由规则
 */
public class Router {
    private static List<String> rules = new LinkedList<>();
    private String msg;
    private StringBuilder stringBuilder = new StringBuilder();

    public Router(String msg){
        this.msg = msg;
    }

    public Router setEmoji(){
        msg = msg.replace(HAHA.getName(),HAHA.getEmoji());
        msg = msg.replace(WUWU.getName(),WUWU.getEmoji());
        return this;
    }

    public Router setPicture(){
        msg = msg.replace(VIEW.getName(),VIEW.getPicture());
        msg = msg.replace(PEOPLE.getName(),PEOPLE.getPicture());
        return this;
    }
    public Router setTail(String tail){
        msg = msg + "  "+tail;
        return this;
    }


    public String build(){
        return msg;
    }

    public enum Emoji{
        /**
         * 定义一些表情
         */
        HAHA("/ha","哈哈") ,WUWU("/wu","呜呜");

        private String name;
        private String emoji;

        Emoji(String name,String e) {
            this.name = name;
            this.emoji=e;
        }

        public String getName() {
            return name;
        }

        public String getEmoji() {
            return emoji;
        }
    }

    public enum Pic{
        /**
         * 定义一些图片
         */
        VIEW("[view]","[风景图]") , PEOPLE("[people]","[人文图]");

        private String name;
        private String picture;

        Pic(String name,String pic) {
            this.name = name;
            this.picture=pic;
        }

        public String getName() {
            return name;
        }

        public String getPicture() {
            return picture;
        }
    }
}


