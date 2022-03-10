# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:

        #     1
        #    /  \
        #   3    4
        #  /  \    \
        # 7    5    8
        if root is None:
            return []

        stack = [root]
        result = []

        # root = [1, 3, 4, 7, 5, 8]
        # result = [1, 3, 7, 5, 4, 8]
        # Iterative solution
        while stack:
            root = stack.pop()
            result.append(root.val)
            if root.right is not None:
                stack.append(root.right)
            if root.left is not None:
                stack.append(root.left)

        return result


# recursive solution
        if root is None:
            return []

        return [root.val] + self.preorderTraversal(root.left) + self.preorderTraversal(root.right)




