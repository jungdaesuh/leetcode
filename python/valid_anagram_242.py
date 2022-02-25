def sort_soln(s, t):
    if len(s) != len(t):
        return False

    if sorted(s) == sorted(t):
        return True
    return False
"""
simpler solution. 

return sorted(s) == sorted(t)
"""

def hash_map_soln(s, t):
    if len(s) != len(t):
        return False

    countS, countT = {}, {}
    for i in range(len(s)):
        countS[s[i]] = 1 + countS.get(s[i], 0)
        countT[t[i]] = 1 + countT.get(t[i], 0)
    for j in countS:
        if countS[s[j]] != countT.get(t[j], 0):
            return False
    return True

