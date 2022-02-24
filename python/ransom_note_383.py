def canConstruct1(self, ransomNote: str, magazine: str) -> bool:
    if len(ransomNote) > len(magazine):
        return False

    magazine_counts = collections.Counter(magazine)
    ransom_counts = collections.Counter(ransomNote)
    #         print(ransom_counts)
    #         print(ransom_counts['a'])

    for char, count in ransom_counts.items():
        # print(char)
        magazine_count = magazine_counts[char]
        # print(magazine_count)
        if magazine_count < count:
            return False
    return True

def canConstruct2(self, ransomNote: str, magazine: str) -> bool:
    for c in ransomNote:
        if c not in magazine:
            return False
        location = magazine.index(c)

        magazine = magazine[:location] + magazine[location + 1:]
    return True
