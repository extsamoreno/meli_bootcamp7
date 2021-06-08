package com.example.link_tracker.controller;


@RestController
@RequestMapping("/tracker")
public class LinkTrackerController {

	@Autowire
	ILinkTrackerService linkTrackerService;

	@PostMapping("/create_link")
	public ResponseEntity<LinkDTOResponse> create(@RequestBody LinkDTORequest) {
		return new ResponseEntity<>(linkTrackerService.createLink, HttpStatus.OK);
	}

	@GetMapping("/link/{linkID}")
	public ModelAndView createLinkWithPath(@PathVariable String linkID, @RequestParam String pass) {
		return new ModelAndView("redirect: " + linkTrackerService);
	}

	@GetMapping("/metrics/{linkID}")
	public ResponseEntity<Integer> getMetrics(@PathVariable String linkID) {
		return new ResponseEntity<Integer> (linkTrackerService.getLinkVisitCount(linkID), HttpStatus.OK);
	}

	@PostMapping("/invalidate")
}
