job('NodeJS example') {
    scm {
        git('https://github.com/kanchansingh1123/ngjenkins.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('kanchansingh1123')
            node / gitConfigEmail('kanchansingh1123@gmail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        shell("npm install")
      shell("ng build")
    }
}
