# Fichier de démonstration pour SonarQube / Bandit / Semgrep
# NE PAS UTILISER EN PRODUCTION

import os
import subprocess
import sqlite3

def insecure_eval(user_input):
    # Exemple d'utilisation dangereuse de eval
    result = eval(user_input)  # vulnérable
    return result

def insecure_subprocess(cmd):
    # Exemple de commande shell construite par concaténation
    os.system("ls " + cmd)  # vulnérable

def insecure_sql(user_id):
    conn = sqlite3.connect("users.db")
    cur = conn.cursor()
    # Requête SQL construite par concaténation
    query = f"SELECT * FROM users WHERE id = {user_id}"  # vulnérable
    cur.execute(query)
    return cur.fetchall()

HARDCODED_PASSWORD = "SuperSecret123"  # code smell / vulnérabilité

def bad_practices(x):
    # Variable non utilisée, complexité inutile
    y = 0
    if x > 0:
        if x > 10:
            print("X > 10")
        else:
            if x > 5:
                print("5 < X <= 10")
            else:
                print("0 < X <= 5")
    else:
        print("X <= 0")

def insecure_popen(user_arg):
    # Utilisation de subprocess avec shell=True et concaténation
    cmd = "ping -c 1 " + user_arg
    subprocess.Popen(cmd, shell=True)  # vulnérable
