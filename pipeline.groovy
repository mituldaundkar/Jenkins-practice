node{
    stage('PULL'){
        echo 'pull SUCCESS'
    }
    stage('BUILD'){
        echo 'build SUCCESS'
    }
    stage('TEST'){
        echo 'test SUCCESS'
    }
    stage('DEPLOY'){
        echo 'deploy SUCCESS'
    }
}