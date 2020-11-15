pipeline {
    agent {
        docker { image 'mariamtoujani/testngtools' }
    }
    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/mariamToujeni/TestNGJenkins.git'

                // Run Maven on a Unix agent.
                sh "mvn clean test -Dwebdriver.chrome.driver=/opt/selenium/chromedriver-86.0.4240.22"

            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
                always {
                    step([$class: 'Publisher', reportFilenamePattern: '**/testng-results.xml'])
                        }
                }
        }
    }
}