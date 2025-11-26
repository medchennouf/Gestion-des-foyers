import ast

def safe_parse(s):
    # n'accepte que des littéraux Python (list, dict, str, int, float, bool, None)
    return ast.literal_eval(s)

# exemple d'utilisation
if __name__ == "__main__":
    text = "['a', 'b']"
    data = safe_parse(text)
    print(data)

