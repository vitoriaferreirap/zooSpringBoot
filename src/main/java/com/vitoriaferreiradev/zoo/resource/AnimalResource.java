@RestController
@RestMapping(value = "/animal")
public class AnimalResource {

    // Animal Resource depende do AnimalService
    @Autowired
    private Animal animalService;

    // endpoints

}
