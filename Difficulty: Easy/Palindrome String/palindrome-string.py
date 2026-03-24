class Solution:
    def isPalindrome(self, s):
        # code here
        rev="".join(reversed(s))
        if s==rev:
            return True
        return False
        
