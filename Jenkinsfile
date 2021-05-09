pipeline {
  agent any

  stages {
         stage('Build') {
            steps {
              sh 'mvn clean package'
            }
            post {
              success {
                echo 'Achiving....'
                sh 'docker build . -t products:${env.BUILD_ID}'
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
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
