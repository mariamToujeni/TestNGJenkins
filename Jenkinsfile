pipeline {
    agent any



    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/mariamToujeni/TestNGJenkins.git'

                // Run Maven on a Unix agent.
                sh "mvn clean test -Dwebdriver.chrome.driver=/home/hamza/workspace/tools/chromedriver_linux64/chromedriver"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
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
