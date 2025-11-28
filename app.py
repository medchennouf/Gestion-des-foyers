from flask import Flask

app = Flask(__name__)

@app.route("/")
def home():
    return "DevSecOps – Gestion des foyers (Docker + Jenkins + Trivy + Gitleaks + ZAP)"

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=8080)
