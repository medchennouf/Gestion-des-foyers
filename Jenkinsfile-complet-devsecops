pipeline {
    agent any

    environment {
        PATH = "/usr/local/bin:/usr/bin:/bin:${env.PATH}"
    }

    stages {

        stage('Declarative: Checkout SCM') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Building project...'
            }
        }

        stage('Unit Tests') {
            steps {
                echo 'Running tests...'
                sh 'pytest --maxfail=1 --disable-warnings -q'
            }
        }

        stage('Security Scan - Bandit') {
    steps {
        echo 'Running Bandit scan...'
        sh 'python3 -m pip install --upgrade bandit' // optionnel si déjà global
        sh '/usr/local/bin/bandit -r . -f json -o bandit.json'
        sh 'head -n 20 bandit.json'
    }
}


        stage('Check Bandit Vulnerabilities') {
            steps {
                sh '''
                python3 - <<EOF
import json
with open("bandit.json") as f:
    data = json.load(f)
issues = []
for file, metrics in data.get("metrics", {}).items():
    if metrics.get("SEVERITY.HIGH", 0) > 0 or metrics.get("SEVERITY.MEDIUM", 0) > 0:
        issues.append(f"{file} | MEDIUM/HIGH issue found")
if issues:
    print("Bandit security issues found:", len(issues))
    for i in issues:
        print(i)
    exit(1)
else:
    print("No Bandit security issues found")
EOF
                '''
            }
        }

        stage('Security Scan - Trivy FS') {
            steps {
                echo 'Running Trivy FS scan...'
                // commande Trivy ici si nécessaire
            }
        }

        stage('Security Scan - Gitleaks') {
            steps {
                echo 'Running Gitleaks scan...'
                // commande Gitleaks ici si nécessaire
            }
        }

        stage('Docker Build') {
            steps {
                echo 'Building Docker image...'
                // docker build commands ici
            }
        }

        stage('Docker Image Security - Trivy') {
            steps {
                echo 'Running Docker image security scan...'
                // docker image scan commands ici
            }
        }

        stage('Final Security Check') {
            steps {
                echo 'Performing final security check...'
                // actions finales si nécessaire
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/*.json', allowEmptyArchive: true
            echo 'Security reports archived'
        }
    }
}
