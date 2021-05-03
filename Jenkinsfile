pipeline {
    agent any

    stages {
         stage('Compile') {
            steps {
                sh 'mvn compile'
            }
        }
        post {
            success {
                stage('Build') {
                    steps {
                        sh 'mvn clean package'
                    }
                    post {
                        success {
                            echo 'Achiving....'
                            archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
                        }
                    }
                }
          }
         stage('Deploying to staging') {
            steps {
                build job: 'deployStaging'
            }
        }
      }
    }
}
