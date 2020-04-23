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

    stage('Multiple Steps') {
      agent any
      steps {
        echo 'Hello World'
        sh '''echo "Hello Pluto"
echo "Multiline shell steps work too"
ls -lah
 '''
      }
    }

  }
}