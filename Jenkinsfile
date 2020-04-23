pipeline {
  agent any

  stages {
    stage('Build Assets') {
      agent any
      steps {
        echo 'Building Assets...'
      }
    }
    stage('Test') {
      agent any
      steps {
        echo 'Testing stuff...'
      }
    }
    stage('Node version') {
      agent {
        docker { image 'node:7-alpine' }
      }
      steps {
        sh 'node --version'
      }
    }
}
}
