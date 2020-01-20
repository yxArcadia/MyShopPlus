cd ..
cd dependencies
call mvn deploy

cd ..
cd provider/ums-admin-provider-api
call mvn deploy

cd ..
cd ums-admin-provider-service
call mvn deploy

cd ..
call mvn deploy

cd ..
cd commons/commons-dto
call mvn deploy

cd ..
cd commons-utils
call mvn deploy

cd ..
call mvn deploy

cd ..
cd configuration/configuration-feign
call mvn deploy

cd ..
call mvn deploy

cd ..
cd business/business-profile/business-profile-feign
call mvn deploy

cd ..
cd business-profile-service
call mvn deploy

cd ..
call mvn deploy

cd ..
cd business-oauth2
call mvn deploy

cd ..
cd business-reg
call mvn deploy

cd ..
call mvn deploy

cd ..
call mvn deploy





