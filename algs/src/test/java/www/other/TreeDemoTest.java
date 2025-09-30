package www.other;

import cn.hutool.core.lang.tree.TreeNode;
import org.junit.Test;
import org.tree.TreeDemoA;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TreeDemoTest {


    @Test
    public void test1() {
        Comparable<Integer> weight = o -> o / 100;
        List<TreeNode<String>> treeNodeList = new ArrayList<>();
        treeNodeList.add(new TreeNode<String>("DD2yhSlA", "0", "龙湖悠山郡千山新屿", weight));
        treeNodeList.add(new TreeNode<String>("97g2tYvz", "DD2yhSlA", "39栋", weight));
        treeNodeList.add(new TreeNode<String>("3Ge5jzEi", "97g2tYvz", "-2至3层联排别墅", weight));
        treeNodeList.add(new TreeNode<String>("wTOVoA2A", "3Ge5jzEi", "空", weight));
        treeNodeList.add(new TreeNode<String>("bBtGnYrU", "wTOVoA2A", "3号", weight));
        TreeDemoA.eachTree(treeNodeList);
    }

    @Test
    public void test2() {
        Comparable<Integer> weight = o -> o / 100;
        List<TreeNode<String>> treeNodeList = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            TreeNode<String> treeNode = new TreeNode<>(UUID.randomUUID().toString().replace("-", ""), "0", String.valueOf(i), weight);
            for (int j = 100; j >= 1; j--) {
                TreeNode<String> node = new TreeNode<>(UUID.randomUUID().toString().replace("-", ""), treeNode.getId(), String.valueOf(i) + "-" + String.valueOf(j), weight);
                treeNodeList.add(node);
            }
            treeNodeList.add(treeNode);
        }
        TreeDemoA.eachTree(treeNodeList);
    }


}
