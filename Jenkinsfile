pipeline {
    agent any
    tools {
        maven 'maven-3.8.4'
    }
    stages {
        stage('Test') {
            steps {
                sh 'mvn -f java-app/pom.xml test'
            }
            post {
                always {
                    junit 'java-app/target/surefire-reports/*.xml'
                }
            }
        }
        stage('Build') {
            steps {
                sh 'mvn -f java-app/pom.xml -B -DskipTests clean package'
            }
            post {
                success {
                    echo "Artifact arşivleniyor..."
                    archiveArtifacts artifacts: '**/*.jar'
                }
            }
        }
    }
}
