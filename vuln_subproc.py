# vuln_subproc.py - subprocess with shell=True (Bandit flags shell invocation)
import subprocess
subprocess.call("echo vulnerable_subproc", shell=True)
