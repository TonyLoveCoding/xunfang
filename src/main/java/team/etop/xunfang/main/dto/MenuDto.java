package team.etop.xunfang.main.dto;

/**
 * @version V1.0
 * @Description:
 * @author: TingFeng Zhang
 * @date: 2017/8/9 11:46
 */
public class MenuDto {
    private Long id;
    private Long parent_id;
    private String menuNmae;

    public MenuDto(Long id, String menuNmae, Long parent_id) {
        this.id = id;
        this.parent_id = parent_id;
        this.menuNmae = menuNmae;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }

    public String getMenuNmae() {
        return menuNmae;
    }

    public void setMenuNmae(String menuNmae) {
        this.menuNmae = menuNmae;
    }
}
