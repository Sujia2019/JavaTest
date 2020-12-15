package BaseTest;

import lombok.Data;

/**
 * @author ：sujia
 * @date ：Created in 2020/12/15 1:22 下午
 * @description：
 * @modified By：
 * @version:
 */
@Data
public class Mode {
    private String name;
    private String rule;
    private Integer number;
    private Integer age;

    public Mode(String name, String rule, Integer number) {
        this.name = name;
        this.rule = rule;
        this.number = number;
    }

    public Mode() {

    }
}
