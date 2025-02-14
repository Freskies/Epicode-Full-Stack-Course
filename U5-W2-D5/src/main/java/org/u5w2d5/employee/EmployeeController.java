package org.u5w2d5.employee;

import com.cloudinary.Cloudinary;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.u5w2d5.response.CreateResponse;

import java.util.List;

@RestController
@RequestMapping ("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {
	private final EmployeeService employeeService;
	private final Cloudinary cloudinary;

	@GetMapping
	@ResponseStatus (HttpStatus.OK)
	public List<EmployeeResponse> findAll () {
		return this.employeeService.findAll();
	}

	@GetMapping ("/{id}")
	@ResponseStatus (HttpStatus.OK)
	public EmployeeDetailResponse findById (@PathVariable Long id) {
		return this.employeeService.findDetailById(id);
	}

	@PostMapping
	@ResponseStatus (HttpStatus.CREATED)
	public CreateResponse save (@RequestBody EmployeeRequest employeeRequest) {
		return this.employeeService.save(employeeRequest);
	}

	@PutMapping ("/{id}")
	@ResponseStatus (HttpStatus.OK)
	public EmployeeDetailResponse update (@PathVariable Long id, @RequestBody EmployeeRequest employeeRequest) {
		return this.employeeService.update(id, employeeRequest);
	}

	@DeleteMapping ("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete (@PathVariable Long id) {
		this.employeeService.deleteById(id);
	}

	@PatchMapping (value = "/{id}/avatar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseStatus (HttpStatus.OK)
	public EmployeeDetailResponse addAvatar (@PathVariable Long id, @RequestPart ("file") MultipartFile file) {
		try {
			var result = cloudinary.uploader().upload(
				file.getBytes(), Cloudinary.asMap("folder", "U5-W2-D5", "public_id", file.getOriginalFilename())
			);
			String url = result.get("secure_url").toString();
			return this.employeeService.addAvatar(id, url);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
