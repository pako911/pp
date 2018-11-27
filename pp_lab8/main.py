import functools as ft
import re
from collections import Counter

# zadanie 1
def increment(lista):
    return (i+1 for i in lista)

# zadanie 2
def iloczyn(ciag_liczb):
    return ft.reduce(lambda x, y : x*y, ciag_liczb)

# zadanie 3
def palindrom(text):
    valids = []
    for c in text:
        if c.isalpha():
            valids.append(c.lower())
    return valids == valids[::-1]


# zadanie 4
def tokenize(text):
    return re.findall(r"[\w]+", text.lower())

# zadanie 5
def remove_stop_words(text):
    with open('stopwords.txt') as input_file:
        stopwords = input_file.read()
        input_file.close()
    stopwords = re.findall(r"[\w]+", stopwords)
    shortwords = re.compile(r'\W*\b\w{1,2}\b')
    query = shortwords.sub('', text).split()
    resultwords = [word for word in query if word.lower() not in stopwords]
    result = ' '.join(resultwords)
    return result

# zadanie 6
def cout_most_frequent(text, n):
    text = remove_stop_words(text)
    text = tokenize(text)
    return Counter(text).most_common(n)


def main():
    lista = [1, 2, 3, 4]

    print("zadanie1: ")
    print("Lista przed inkrementacja: ", lista)
    print("Lista po inkrementacji: ", list(increment(lista)))

    print("\nzadanie2: ")
    print("Iloczyn liczb w ciagu:" , iloczyn(lista))

    print("\nzadanie3: ")
    tekst = "Tolo ma samolot"
    if (palindrom(tekst)):
        print("Zdanie: \"", tekst, "\" jest palindromem")
    else:
        print("Zdanie: ", tekst, 'nie jest palindromem')

    print("\nzadanie4: ")
    tekst2 = "To be, or not to be - that is the question [...]"
    print(tokenize(tekst2))

    print("\nzadanie5: ")
    with open('input.txt') as input_file:
        tekst3 = input_file.read()
        input_file.close()
    print("Wczytany tekst: ", tekst3)
    print("Tekst po usunieciu stop words:", remove_stop_words(tekst3))

    print("\nzadanie6: ")
    with open('trurl.txt') as input_file:
        tekst4 = input_file.read()
        input_file.close()
    print("Najczęściej występujące słowa:", cout_most_frequent(tekst4, 20))

main()