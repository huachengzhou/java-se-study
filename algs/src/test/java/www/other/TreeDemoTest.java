package www.other;

import cn.hutool.core.lang.tree.TreeNode;
import org.junit.Test;
import org.tree.TreeDemoA;

import java.util.ArrayList;
import java.util.List;

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


}
