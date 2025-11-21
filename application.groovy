pipeline{
    agent any
    stages{
        stage('PULL'){
            steps{
                git branch: 'devops', url: 'https://github.com/shubhamkalsait/EasyCRUD.git'
            }
        }
        stage('FRONTEND DOCKER-BUILD'){
            steps{
                sh '''cd frontend
                        docker build . -t mituldaundkar/easy-frontend:latest'''
            }
        }
        stage('BACKEND DOCKER-BUILD'){
            steps{
                sh '''cd backend
                    docker build . -t mituldaundkar/easy-backend:latest'''
            }
        }
        stage('DOCKER-PUSH'){
            steps{
                sh '''docker push mituldaundkar/easy-frontend:latest
                        docker push mituldaundkar/easy-backend:latest'''
            }
        }
         stage('DOCKER-CLEAN'){
            steps{
                sh '''docker rmi mituldaundkar/easy-frontend:latest
                        docker rmi mituldaundkar/easy-backend:latest'''
            }
        }
        stage('DEPLOY'){
            steps{
                sh 'kubectl apply -f simple-deploy/'
            }
        }
    }
}