package hello.servlet.domain.member;

import com.auth0.jwt.algorithms.Algorithm;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class JwtTest {

    //HMAC
    Algorithm algorithmHS = Algorithm.HMAC256("secret");

    //RSA
    //RSAPublicKey publicKey = //Get the key instance
    //RSAPrivateKey privateKey = //Get the key instance
  //  Algorithm algorithmRS = Algorithm.RSA256(publicKey, privateKey);

    //final JwkStore jwkStore = new JwkStore("{JWKS_FILE_HOST}");
//    final RSAPrivateKey privateKey = //Get the key instance
//    final String privateKeyId = //Create an Id for the above key
//    RSAKeyProvider keyProvider = new RSAKeyProvider() {
//        @Override
//        public RSAPublicKey getPublicKeyById(String kid) {
//            //Received 'kid' value might be null if it wasn't defined in the Token's header
//            RSAPublicKey publicKey = jwkStore.get(kid);
//            return (RSAPublicKey) publicKey;
//        }
//
//        @Override
//        public RSAPrivateKey getPrivateKey() {
//            return privateKey;
//        }
//
//        @Override
//        public String getPrivateKeyId() {
//            return privateKeyId;
//        }
//    };
}
