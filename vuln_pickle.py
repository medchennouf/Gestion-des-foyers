# vuln_pickle.py - use of pickle.loads (Bandit flags this)
import pickle
data = pickle.dumps({"ok": 1})
obj = pickle.loads(data)
print(obj)
