class Solution:
    def iterative_inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        stack = []

        curr = root
        while curr is not None or stack != []:
            while curr is not None:
                stack.append(curr)
                curr = curr.left
            curr = stack.pop()
            result.append(curr.val)
            curr = curr.right
        return result

    def recursive_inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        if root is None:
            return []

        return self.inorderTraversal(root.left) + [root.val] + self.inorderTraversal(root.right)

