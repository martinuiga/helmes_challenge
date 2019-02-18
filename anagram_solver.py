import datetime
from itertools import permutations


# Start the timer
start = datetime.datetime.now()

def return_words(lst, word_set):
    """
    Return combinations in that are words in word_set
    @type lst: [str]
    @type word_set: set(str)
    @rtype: [str]
    """
    returned_list = []

    for word in lst:
        if word in word_set:
            returned_list.append(word)

    return returned_list


#anagram = sys.argv[1]
#file_path = sys.argv[2]

anagram = "kalpaam"
anagramLength = len(anagram)


# Make all the comibations of the given word
possible_words = set([''.join(p) for p in permutations(anagram)])


word_array = []
with open("lemmad_encoded.txt", "r") as lines:
    for line in lines:
        if len(line.rstrip('\n')) == anagramLength:
           word_array.append(line.rstrip('\n').lower())


# Calculate the matches from lemmad.txt
actual_words = return_words(possible_words, word_array)

# End the timer
end = datetime.datetime.now()

print(actual_words)
print(end-start)
