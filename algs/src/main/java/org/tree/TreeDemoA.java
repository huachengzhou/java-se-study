package org.tree;

import cn.hutool.core.lang.tree.TreeNode;

import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class TreeDemoA {


    /**
     * 树的遍历
     *
     * @param treeNodeList
     */
    public static void eachTree(List<TreeNode<String>> treeNodeList) {
        Map<String, List<TreeNode<String>>> listMap = treeNodeList.stream().collect(Collectors.groupingBy(TreeNode::getParentId));
        Stack<TreeNode<String>> stack = new Stack<>();
        for (TreeNode<String> rootNode : listMap.get("0")) {
            stack.push(rootNode);
            while (!stack.isEmpty()) {
                TreeNode<String> node = stack.pop();
                System.out.println(node.getName());
                List<TreeNode<String>> children = listMap.get(node.getId());
                if (children == null || children.isEmpty()) {
                    continue;
                }
                for (TreeNode<String> child : children) {
                    stack.push(child);
                }
            }
        }
    }


}
