package team.etop.xunfang.common.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @version V1.0
 * @Description:构造后台菜单树
 * @author: TingFeng Zhang
 * @date: 2017/8/9 14:18
 */
public class BuildTree {
    public static <T> List<Tree<T>> build(List<Tree<T>> nodes) {

        if (nodes == null) {
            return null;
        }
        List<Tree<T>> topNodes = new ArrayList<>();

        for (Tree<T> children : nodes) {

            String pid = children.getParentId();
            if (pid.equals(children.getId() ) || "0".equals(pid)) {
                topNodes.add(children);
                continue;
            }
            for (Tree<T> parent : nodes) {
                String id = parent.getId();
                if (id != null && id.equals(pid)) {
                    parent.getChildren().add(children);
                }
            }
        }

        return topNodes;
    }


}
