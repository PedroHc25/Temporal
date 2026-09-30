package pe.edu.uni.demosec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class ControllerAutenticacion {

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/auth")
    public ResponseEntity<String> authenticate(@RequestBody AuthRequest authRequest) {
        if ("admin".equals(authRequest.getUsername()) && "password".equals(authRequest.getPassword())) {
            return ResponseEntity.ok(jwtUtil.generateToken(authRequest.getUsername()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}