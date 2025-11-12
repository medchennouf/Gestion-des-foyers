# vuln_eval.py - use of eval (Bandit flags this)
user_input = "2+2"
result = eval(user_input)
print("result", result)
